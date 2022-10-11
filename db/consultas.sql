-- Dupla: Lucas Portela Lopes e Vinícius Matté Medeiros.

-- Consultas

-- Geral - Tela Categoria 
-- Dada uma categoria retorna a descrição dos produtos e do vendedor de cada produto.
-- Tabelas utilizadas: categoria_produto, produto  e vendedor.
-- SELECT  produto.id_produto,
--         produto.nome as produto_nome,
--         produto.descricao, 
-- 	      imagem_url, 
--         preco, 
--         vendedor.id_vendedor,
-- 	      vendedor.nome as vendedor_nome,
--         vendedor.nota,
-- 	      categoria_produto.nome as categoria_nome,
-- 	      categoria_produto.descricao as categoria_descricao
--   FROM categoria_produto
--   INNER JOIN produto ON (categoria_produto.id_categoria_produto = produto.id_categoria)
--   INNER JOIN vendedor USING (id_vendedor)
--   WHERE categoria_produto.id_categoria_produto = ?? AND estoque > 0;
---------------------------------------------------------------------------------------------------------------------------
-- Geral 2 - Lista os endereços do cliente
-- Tabelas utilizadas: cliente, cliente_vendedor_endereco e endereço
-- SELECT  id_cliente_vendedor_endereco,
--         logradouro, 
-- 	      endereco.numero, 
-- 	      cidade, 
-- 	      uf,
-- 	      complemento
--   FROM cliente 
--   NATURAL JOIN cliente_vendedor_endereco 
--   NATURAL JOIN endereco 
--   WHERE id_cliente = ?1
---------------------------------------------------------------------------------------------------------------------------
-- Geral 3 - Lista produtos do carrinho do cliente
-- SELECT  produto.id_produto,
--         produto.nome as nome_produto,
--         imagem_url,
--         descricao,
--         preco,
--         vendedor.nome as nome_vendedor
--   FROM produto
--   JOIN carrinho_produto USING (id_produto)
--   JOIN vendedor ON (produto.id_vendedor = vendedor.id_vendedor)
--   WHERE id_carrinho = ?1
---------------------------------------------------------------------------------------------------------------------------
-- View - Tela Meus Pedidos
-- Dado um cliente retorna detalhes básicos de todos os seus pedidos
-- Tabelas utilizadas: ClientePedido, transportadora, endereco e cartao_credito
CREATE VIEW ClientePedido 
AS SELECT * 
      FROM cliente NATURAL JOIN pedido

-- SELECT  id_pedido,
--         data_realizacao,
-- 	      transportadora.nome as nome_transportadora,
--         endereco.logradouro,
--         endereco.numero,
--         endereco.cidade,
--         endereco.uf,
--         endereco.complemento,
--         cartao_credito.nome as nome_cartao_credito,
--         cartao_credito.numero
--   FROM ClientePedido
--   INNER JOIN cartao_credito USING (id_cartao_credito)
--   INNER JOIN endereco USING (id_endereco)
--   INNER JOIN transportadora USING (id_transportadora)
--   WHERE id_cliente = ?1;
---------------------------------------------------------------------------------------------------------------------------
-- View 2 - Tela Detalhes do Pedido
-- Exibir os produtos de um pedido para o cliente
-- Tabelas utilizadas: ClientePedido, pedido_produto, produto, e vendedor.
-- SELECT  id_produto,
--         vendedor.nome as nome_vendedor,
--         imagem_url,
--         produto.nome as nome_produto,
--         preco
--   FROM ClientePedido
--   INNER JOIN pedido_produto USING (id_pedido)
--   INNER JOIN produto USING (id_produto)
--   INNER JOIN vendedor ON (produto.id_vendedor = vendedor.id_vendedor)
--   WHERE id_pedido = ?1;
---------------------------------------------------------------------------------------------------------------------------
-- Group By - Tela Carrinho de Compras 
-- Quantidade de itens e valor total dos produtos do carrinho do cliente.
-- Tabelas utilizadas: cliente, carrinho, carrinho_produto e produto.
-- SELECT  COUNT(*) qtde, 
--         SUM(preco) valor_total
--   FROM cliente
--   NATURAL JOIN carrinho
--   NATURAL JOIN carrinho_produto
--   INNER JOIN produto USING (id_produto)
--   GROUP BY id_carrinho, id_cliente
--   HAVING id_cliente = ?1
---------------------------------------------------------------------------------------------------------------------------
-- Group By com Having - Métricas do Vendedor
-- Total de vendas e o valor total que cada vendedor arrecadou em um determinado período.
-- Tabelas utilizadas: pedido_produto, produto e pedido.
-- SELECT  COUNT(*) qtde_vendas,
--         SUM(preco) valor_arrecadado
--   FROM  pedido_produto NATURAL JOIN
--         produto NATURAL JOIN
--         pedido
--   WHERE data_realizacao >= ?2 AND data_realizacao <= ?3
--   GROUP BY id_vendedor
--   HAVING id_vendedor = ?1;
---------------------------------------------------------------------------------------------------------------------------
-- Subconsulta - Lembrete por email
-- Nome e email dos clientes que ainda não completaram o cadastro na plataforma, ou seja, não cadastraram endereço e/ou cartão de crédito. (Usado para enviar e-mail relembrando o cliente de completar o cadastro.)
-- Tabelas utilizadas: cliente, cliente_vendedor_endereco, cartao_credito_cliente.
-- SELECT  id_cliente,
--         nome,
--         email
--   FROM cliente 
--   WHERE id_cliente IN (SELECT id_cliente
--     FROM cliente_vendedor_endereco 
--     WHERE id_endereco is null 
--     UNION
--     SELECT id_cliente
--     FROM cartao_credito_cliente
--     WHERE id_cartao_credito is null);
---------------------------------------------------------------------------------------------------------------------------
-- Subconsulta 2 - Email de motivação para vendedor
-- Nome e email do vendedor que não realizou vendas nos últimos 30 dias
-- Tabelas utilizadas: vendedor, pedido, pedido_produto, produto.
-- SELECT  id_vendedor,
--         nome,
--         email
--   FROM vendedor
--   WHERE id_vendedor NOT IN (SELECT id_vendedor
--     FROM pedido NATURAL JOIN 
--     pedido_produto NATURAL JOIN
--     produto
--     WHERE data_realizacao > 'hoje-30dias-data');
---------------------------------------------------------------------------------------------------------------------------
-- Not Exists - Lista os clientes que ainda não realizaram pedidos. Se o cliente nunca realizou pedidos poderá ser oferecido cupom de desconto para primeira compra, ou enviado um email específico, por exemplo. Optamos por essa consulta, já que apesar de não utilizar 3 tabelas, faz mais sentido para nossa aplicação.
-- SELECT *
--   FROM cliente
--   WHERE NOT EXISTS (SELECT *
--     FROM pedido
--     WHERE cliente.id_cliente = pedido.id_cliente)
---------------------------------------------------------------------------------------------------------------------------
-- Gatilho
-- Se o estoque do produto chegar a zero, o produto é removido dos carrinhos onde está     -- inserido.
CREATE FUNCTION estoqueZero() RETURNS TRIGGER AS $LimparCarrinho$
	BEGIN
		IF (SELECT estoque FROM produto WHERE id_produto = NEW.id_produto) = 0 THEN
		DELETE FROM carrinho_produto 
		WHERE id_produto = NEW.id_produto;
	END IF;
	RETURN NEW;
END;
$LimparCarrinho$ LANGUAGE plpgsql;

CREATE TRIGGER LimparCarrinho
	AFTER UPDATE ON produto
	FOR EACH ROW
	EXECUTE PROCEDURE estoqueZero();
---------------------------------------------------------------------------------------------------------------------------
-- Demais consultas necessárias para telas / fluxos
-- Procurar cliente ou vendedor por senha (para login).
-- SELECT *
--   FROM cliente
--   WHERE email = 'eduardalaviniadacruz@hotmailo.com' and senha = 'mxo4q9nkB2';

-- SELECT *
--   FROM vendedor
--   WHERE email = 'martin_assuncao@jci.com' and senha = 'bWxp8m7nDC';
---------------------------------------------------------------------------------------------------------------------------
-- Procurar cliente ou vendedor por email (para cadastro) *evita que o mesmo email seja cadastrado duas vezes.
-- SELECT 1 
--   FROM cliente
--   WHERE email = 'abc@email.com'

-- SELECT 1 
--   FROM vendedor 
--   WHERE email = 'abc@email.com'
---------------------------------------------------------------------------------------------------------------------------
-- Lista todos os produtos disponíveis (todas as categorias).
-- SELECT  produto.id_produto,
--         produto.nome as produto_nome,
--         produto.descricao, 
--         imagem_url, 
--         preco, 
--         vendedor.id_vendedor,
-- 	      vendedor.nome as vendedor_nome,
--         vendedor.nota,
--         categoria_produto.nome as categoria_nome,
--         categoria_produto.descricao as categoria_descricao
--   FROM categoria_produto
--   INNER JOIN produto ON (categoria_produto.id_categoria_produto = produto.id_categoria)
--   INNER JOIN vendedor USING (id_vendedor)
--   WHERE estoque > 0;
---------------------------------------------------------------------------------------------------------------------------
-- Lista todos os produtos de um determinado vendedor.
-- SELECT  produto.id_produto,
--         produto.nome as produto_nome,
--         produto.descricao, 
--         imagem_url, 
--         preco, 
--         vendedor.id_vendedor,
-- 	      vendedor.nome as vendedor_nome,
--         vendedor.nota,
--         categoria_produto.nome as categoria_nome,
--         categoria_produto.descricao as categoria_descricao
--   FROM categoria_produto
--   INNER JOIN produto ON (categoria_produto.id_categoria_produto = produto.id_categoria)
--   INNER JOIN vendedor USING (id_vendedor)
--   WHERE vendedor.id_vendedor = ?1 and estoque > 0;
---------------------------------------------------------------------------------------------------------------------------
-- Listar produtos a partir de título (pesquisa).
-- SELECT  produto.id_produto,
--         produto.nome as produto_nome,
--         produto.descricao,
--         imagem_url,
--         preco,
--         vendedor.id_vendedor,
-- 	      vendedor.nome as vendedor_nome,
--         vendedor.nota,
--         categoria_produto.nome as categoria_nome,
--         categoria_produto.descricao as categoria_descricao
--   FROM categoria_produto
--   INNER JOIN produto ON (categoria_produto.id_categoria_produto = produto.id_categoria)
--   INNER JOIN vendedor USING (id_vendedor)
--   WHERE LOWER(produto.nome) LIKE LOWER(CONCAT('%', '?texto', '%')) AND estoque > 0
---------------------------------------------------------------------------------------------------------------------------
-- Retorna cupom entre 10% e 20% de desconto.
-- SELECT * 
--   FROM cupom 
--   WHERE porcentagem_desconto >= 0.10 AND porcentagem_desconto <= 0.20
--   LIMIT (1);
---------------------------------------------------------------------------------------------------------------------------
-- Retorna cupom de mais de 20% de desconto.
-- SELECT * 
--   FROM cupom 
--   WHERE porcentagem_desconto > 0.20
--   LIMIT (1);
---------------------------------------------------------------------------------------------------------------------------
-- Retorna cupom de frete grátis, que por padrão é aquele que não tem porcentagem de desconto definida. Obs: A oferta desse cupom será randômica.
-- SELECT * 
--   FROM cupom 
--   WHERE porcentagem_desconto IS NULL 
--   LIMIT(1);
---------------------------------------------------------------------------------------------------------------------------
-- Lista transportadoras para seleção na hora de efetuar pedido.
-- SELECT * 
--   FROM transportadora;
---------------------------------------------------------------------------------------------------------------------------
-- Lista cartões de crédito cadastrados por um usuário específico.
-- SELECT * 
--   FROM cartao_credito
--   JOIN cartao_credito_cliente USING (id_cartao_credito)
--   WHERE id_cliente = ?1;
---------------------------------------------------------------------------------------------------------------------------
-- Retorna os endereços de um vendedor específico
-- SELECT  id_cliente_vendedor_endereco,
--         logradouro, 
-- 	      endereco.numero, 
-- 	      cidade, 
-- 	      uf,
-- 	      complemento
--   FROM vendedor
--   NATURAL JOIN cliente_vendedor_endereco 
--   NATURAL JOIN endereco 
--   WHERE id_vendedor = ?1
---------------------------------------------------------------------------------------------------------------------------
-- Retorna a quantidade de vendas de um vendedor específico.
-- SELECT COUNT(*) 
--   FROM pedido_produto
--   JOIN produto ON (produto.id_produto = pedido_produto.id_produto)
--   WHERE produto.id_vendedor = ?1
---------------------------------------------------------------------------------------------------------------------------
-- Lista todas as categorias.
-- SELECT * 
--   FROM categoria_produto;
---------------------------------------------------------------------------------------------------------------------------
-- Lista as avaliações de determinado produto.
-- SELECT * 
--   FROM avaliacao 
--   WHERE id_produto = ?1;
---------------------------------------------------------------------------------------------------------------------------
-- Lista os pedidos para o vendedor
-- SELECT  data_realizacao,
--         produto.nome as nome_produto,
--         imagem_url,
-- 	      transportadora.nome as nome_transportadora,
--         ClientePedido.nome as nome_cliente
--   FROM ClientePedido
--   INNER JOIN pedido_produto USING (id_pedido)
--   INNER JOIN produto USING (id_produto)
--   INNER JOIN vendedor ON (produto.id_vendedor = vendedor.id_vendedor)
--   INNER JOIN transportadora USING (id_transportadora)
--   WHERE vendedor.id_vendedor = ?1


---------------------------------------------------------------------------------------------------------------------------
-- Teste do gatilho:
select * from carrinho_produto;    
UPDATE produto SET estoque = 0 WHERE id_produto = 2;    
select * from carrinho_produto;    
-- Zerando o estoque do produto 2 é possível ver que ele não permance no carrinho 