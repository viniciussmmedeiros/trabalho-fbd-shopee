-- Consultas

-- Geral - Tela Categoria
-- Dada uma categoria retorna a descrição dos produtos e do vendedor de cada produto.
-- (categoria_produto + produto + vendedor)
SELECT  produto.nome, 
	      imagem_url, 
	      produto.descricao, 
        preco, 
	      vendedor.nome
FROM categoria_produto
INNER JOIN produto ON (categoria_produto.id_categoria_produto = produto.id_categoria)
INNER JOIN vendedor USING (id_vendedor)
WHERE categoria_produto.nome = 'Celulares e Dispositivos'

-- Geral 2 - Tela Minha Conta
-- Exibir as informações do Cliente
-- (cliente + endereço + cartao_credito + cliente_vendedor_endereco + cartao_credito_cliente)
SELECT  cliente.nome, 
        email, 
	      cpf, 
	      logradouro, 
	      endereco.numero, 
	      cidade, 
	      uf, 
	      complemento, 
	      cartao_credito.numero
FROM cliente 
NATURAL JOIN cliente_vendedor_endereco
NATURAL JOIN cartao_credito_cliente 
NATURAL JOIN endereco 
INNER JOIN cartao_credito USING (id_cartao_credito);

-- Geral 3 - Tela Detalhes do Produto, para categorias específicas
-- Exibir as informações do produto
-- (categoria_produto  + produto + vendedor + avaliacao)
SELECT  produto.nome, 
	      produto.descricao, 
	      produto.imagem_url, 
	      preco, 
        categoria_produto.nome, 
	      categoria_produto.descricao, 
	      vendedor.nome, 
				nota, 
	      avaliacao.imagem_url, 
	      comentario
FROM produto 
INNER JOIN  vendedor USING (id_vendedor) 
INNER JOIN categoria_produto ON (categoria_produto.id_categoria_produto = produto.id_categoria)
LEFT JOIN avaliacao USING (id_produto)
WHERE produto.estoque > 0;

-- View - Tela Minhas Compras
-- Exibir os pedidos realizados por um cliente;
-- (ClientePedido  + transportadora + vendedor + carrinho +  produto + carrinho_produto)
SELECT vendedor.nome NomeVendedor,
	   	 produto.nome NomeProduto,
	   	 transportadora.nome NomeTransportadora,
	   	 preco
FROM ClientePedido 
NATURAL JOIN  carrinho
INNER JOIN transportadora USING (id_transportadora)
NATURAL JOIN carrinho_produto
INNER JOIN produto USING (id_produto)
INNER JOIN vendedor USING (id_vendedor)
WHERE ClientePedido.nome = 'Eduarda Lavínia da Cruz';

-- View 2 - Tela Detalhes do Pedido
-- Exibir os detalhes de um pedido
-- (Cliente + Pedido) + Endereço + Cartão de Crédito + (Cupom e Transportadora ?) 

-- Group By - Tela Carrinho de Compras (Opção: Selecionar todos os produtos)
-- Quantidade de itens e valor total dos produtos do carrinho do cliente.
-- (Cliente + Carrinho + Produto)

-- Group By com Having - Métricas do Vendedor
-- Total de vendas e o valor total que cada vendedor arrecadou a partir de uma determinada data. 
-- Pedido + Cliente + Vendedor (Confirmar se são 3 tabelas necessárias para a consulta)
-- ** Incluir a data que o pedido foi realizado na entidade Pedido
SELECT * FROM pedido pe
	JOIN pedido_produto USING (id_pedido)
	JOIN produto p USING (id_produto)
	WHERE p.id_vendedor = ?1
	GROUP BY pe.data_realizacao
	HAVING pe.data_realizacao >= ?2 AND pe.data_realizacao <= ?3

-- Subconsulta - Lembrete por email
-- Nome e email dos clientes que ainda não completaram o cadastro na plataforma, ou seja, não cadastraram endereço e/ou cartão de crédito. (Usado para enviar e-mail relembrando o cliente de completar o cadastro.)
-- Cliente + Cartão de Crédito + Endereço

-- Subconsulta 2 - Email de motivação para vendedor
-- Nome e email do vendedor que não realizou vendas nos últimos 30 dias.
-- (Vendedor + Pedido + )

-- Not Exists - 

-- Consultas necessárias para tela / fluxos

-- - Procurar cliente ou vendedor por email (para cadastro) *evita que o mesmo email seja cadastrado duas vezes
-- lembrar de não explicitar o erro para o usuário
SELECT COUNT(*) FROM vendedor WHERE email = 'abc@email.com'
SELECT COUNT(*) FROM cliente WHERE email = 'abc@email.com'

-- - Listar todos os produtos disponíveis, de todas as categorias
SELECT  produto.nome, 
	      produto.descricao, 
	      produto.imagem_url, 
	      preco, 
	      vendedor.nome
FROM produto 
INNER JOIN  vendedor USING (id_vendedor)
WHERE produto.estoque > 0;

-- - Listar todos os produtos disponíveis de um determinado vendedor
SELECT  produto.nome, 
	      produto.descricao, 
	      produto.imagem_url,
	      preco, 
        categoria_produto.nome, 
	      categoria_produto.descricao, 
	      vendedor.nome, 
				nota, 
	      avaliacao.imagem_url, 
	      comentario
FROM produto 
INNER JOIN  vendedor ON (produto.id_vendedor = ?1)
LEFT JOIN avaliacao USING (id_produto)
WHERE produto.estoque > 0;

-- - Listar todos os produtos de determinada categoria
SELECT * FROM produto p
	INNER JOIN categoria_produto c ON (p.id_categoria = c.id_categoria_produto)
	WHERE c.nome = 'Beleza'

-- - Listar produtos a partir de título (pesquisa)
SELECT * FROM produto WHERE LOWER(nome) LIKE LOWER(CONCAT('%', 'S20', '%'))

-- - Verificar se o cliente logado não tem nenhum pedido, para fornecer o cupom de primeira compra
SELECT COUNT(*)
	FROM cliente
	WHERE NOT EXISTS (SELECT
		id_cliente
		FROM pedido
		WHERE id_cliente = 1)

-- - Liberar cupons conforme o valor atual do carrinho (% de desconto, frete grátis..)
-- Libera 10% se o valor atual for 150
SELECT * FROM cupom
	JOIN carrinho USING (id_cupom)
	WHERE (valor_total >= 150 AND id_carrinho = ?1) AND porcentagem_desconto = 0.10
	LIMIT (1);
-- Libera 20% se o valor atual for 480
SELECT * FROM cupom
	JOIN carrinho USING (id_cupom)
	WHERE (valor_total >= 480 AND id_carrinho = ?1) AND porcentagem_desconto = 0.20
	LIMIT (1);

-- - Lista transportadoras para seleção na hora de efetuar pedido
SELECT * FROM transportadora;

-- - Selecionar cartões de crédito cadastrados pelo usuário
SELECT * FROM cartao_credito_cliente WHERE id_cliente = 1;

-- - Quantidade de vendas do vendedor
SELECT COUNT(*) FROM pedido_produto
	JOIN produto ON (produto.id_produto = pedido_produto.id_produto)
	WHERE produto.id_vendedor = ?1

-- - Tela do produto necessita do número de avaliações, número de itens vendidos, dados do produto, dados do vendedor, avaliações e seus respectivos dados… (possivelmente incluir produtos semelhantes na parte debaixo da página ao clique de um botão, mostrando condicionalmente produtos onde categoria = categoria do produto atual, o que seria uma consulta a parte)


-- -> conseguir a avaliação do vendedor (média de suas avaliações)
-- -> conseguir o número de avaliações do produto
-- -> # deve conseguir remover itens do carrinho / ao efetuar pedido o -- carrinho deve ser limpo / ao criar um usuário, deve ser criado um carrinho e atrelado ao id do usuário
-- -> Tela de vendedor tem os próprios produtos, quantidade de vendas e própria avaliação
-- -> card do produto tem o número de itens vendidos, nome do vendedor e dados do produto em si