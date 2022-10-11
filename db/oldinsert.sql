INSERT INTO carrinho (valor_total) VALUES (null);
INSERT INTO carrinho (valor_total) VALUES (null);
INSERT INTO carrinho (valor_total) VALUES (null);

INSERT INTO cliente (nome, email, senha, cpf, id_carrinho) 
  VALUES ('Eduarda Lavínia da Cruz', 'eduardalaviniadacruz@hotmailo.com', 'mxo4q9nkB2', '95433637654', 1);
INSERT INTO cliente (nome, email, senha, cpf, id_carrinho) 
  VALUES ('Raimundo Samuel Levi Ribeiro', 'raimundo_samuel_ribeiro@yande.com.br', '22NRuwIHGL', '09410246601', 2);
INSERT INTO cliente (nome, email, senha, cpf, id_carrinho) 
  VALUES ('Lúcia Aline Aragão', 'luciaalinearagao@vemter.com.br', 'zJ4trLfOSB', '41733844830', 3);

INSERT INTO vendedor (nome, email, senha, cnpj)
  VALUES ('Martin Sérgio Benedito Assunção', 'martin_assuncao@jci.com', 'bWxp8m7nDC', '26333554000102');
INSERT INTO vendedor (nome, email, senha, cnpj)
  VALUES ('Bianca Rosa Almada', 'bianca-almada72@nextel.com.br', 'eR8XCn3STn', '82173281000149');
INSERT INTO vendedor (nome, email, senha, cnpj)
  VALUES ('Lucca Kevin Assis', 'lucca_assis@ceuazul.ind.br', 'gl9O2NHRxt', '00995862000100');

INSERT INTO endereco (logradouro, numero, cidade, uf, complemento)
  VALUES ('Travessa Santa Lúcia II', 296, 'Parnaíba', 'PI', null);
INSERT INTO endereco (logradouro, numero, cidade, uf, complemento)
  VALUES ('Praça dos Imigrantes', 133, 'São Caetano do Sul', 'SP', '305');
INSERT INTO endereco (logradouro, numero, cidade, uf, complemento)
  VALUES ('Rua Florianópolis', 690, 'Cacoal', 'RO', null);

INSERT INTO cliente_vendedor_endereco (id_cliente, id_vendedor, id_endereco)
  VALUES (1, null, 1);
INSERT INTO cliente_vendedor_endereco (id_cliente, id_vendedor, id_endereco)
  VALUES (null, 2, 2);
INSERT INTO cliente_vendedor_endereco (id_cliente, id_vendedor, id_endereco)
  VALUES (2, null, 3);

INSERT INTO cartao_credito (nome, numero, data_vencimento, cvv)
  VALUES ('JOAO J OAOJ', '5591 7624 1688 5845', '07/06/2023', '803');
INSERT INTO cartao_credito (nome, numero, data_vencimento, cvv)
  VALUES ('MARIA M AIRAM', '5307 0454 0385 5798', '07/01/2023', '756');
INSERT INTO cartao_credito (nome, numero, data_vencimento, cvv)
  VALUES ('FULANO F ONALUF', '5556 1480 1426 8340', '07/02/2024', '599');

INSERT INTO cartao_credito_cliente (id_cartao_credito, id_cliente)
  VALUES (1, 1);
INSERT INTO cartao_credito_cliente (id_cartao_credito, id_cliente)
  VALUES (2, 1);
INSERT INTO cartao_credito_cliente (id_cartao_credito, id_cliente)
  VALUES (2, 2);
INSERT INTO cartao_credito_cliente (id_cartao_credito, id_cliente)
  VALUES (3, 3);

INSERT INTO transportadora (nome)
  VALUES ('Transportadora Rápida');
INSERT INTO transportadora (nome)
  VALUES ('Transportadora Hoje');
INSERT INTO transportadora (nome)
  VALUES ('Transportadora Flash');

INSERT INTO categoria_produto (nome, descricao)
  VALUES ('Eletrônicos', 'Itens para trabalho, estudo, diversão.');
INSERT INTO categoria_produto (nome, descricao)
  VALUES ('Beleza', 'Itens para cuidados pessoais.');
INSERT INTO categoria_produto (nome, descricao)
  VALUES ('Automóveis', 'Itens para customização e manutenção de veículos.');

INSERT INTO produto (nome, imagem_url, descricao, estoque, preco, id_vendedor, id_categoria)
  VALUES ('IPhone 8 Plus', 'https://imgs.casasbahia.com.br/50005208/1xg.jpg?imwidth=500', 'Produto original, confia.', true, 1899, 1, 1);
INSERT INTO produto (nome, imagem_url, descricao, estoque, preco, id_vendedor, id_categoria)
  VALUES ('Sachê de Mel Capilar', 'https://cf.shopee.com.br/file/d2e6b7b839d9491e4c3e8415d5bb9e74', 'O MEL CAPILAR é enriquecido com mel e geleia real que possuem propriedades nutritivas que reconstroem a fibra capilar danificada pela ação química, conferindo um brilho radiante.', true, 7, 2, 2);
INSERT INTO produto (nome, imagem_url, descricao, estoque, preco, id_vendedor, id_categoria)
  VALUES ('Kit 2 Pneu Roda Maciça Para Carrinho De Carga', 'https://http2.mlstatic.com/D_NQ_NP_706983-MLB42334066154_062020-O.webp', 'NÃO FURA, NÃO ESVAZIA, NÃO PRECISA DE MANUTEÇÃO', true, 139.90, 3, 3);

INSERT INTO cupom (codigo, disponivel, porcentagem_desconto)
  VALUES ('40OFF', true, 0.4);
INSERT INTO cupom (codigo, disponivel, porcentagem_desconto)
  VALUES ('FRETEGRATIS1', false, null);
INSERT INTO cupom (codigo, disponivel, porcentagem_desconto)
  VALUES ('10OFF', false, 0.1);

INSERT INTO avaliacao (nota, imagem_url, comentario, id_produto)
  VALUES (4.8, null, 'Muito bom, mas é falso.', 1);
INSERT INTO avaliacao (nota, imagem_url, comentario, id_produto)
  VALUES (5, 'https://previews.123rf.com/images/badmanproduction/badmanproduction1207/badmanproduction120700174/14381950-bald-guy-blinking.jpg', 'Horrível, fiquei careca, mas gostei.', 2);
INSERT INTO avaliacao (nota, imagem_url, comentario, id_produto)
  VALUES (0, null, 'Furou tudo.', 3);

INSERT INTO pedido (id_cliente, id_cupom, id_transportadora)
  VALUES (1, null, 1);
INSERT INTO pedido (id_cliente, id_cupom, id_transportadora)
  VALUES (2, null, 2);
INSERT INTO pedido (id_cliente, id_cupom, id_transportadora)
  VALUES (3, null, 3);

INSERT INTO carrinho_produto (id_carrinho, id_produto)
  VALUES (1, 1);
INSERT INTO carrinho_produto (id_carrinho, id_produto)
  VALUES (1, 2);
INSERT INTO carrinho_produto (id_carrinho, id_produto)
  VALUES (1, 3);
INSERT INTO carrinho_produto (id_carrinho, id_produto)
  VALUES (2, 1);
INSERT INTO carrinho_produto (id_carrinho, id_produto)
  VALUES (3, 1);

-- exemplo select da relação produto-carrinho com a tabela intermediária
-- select * from produto JOIN carrinho_produto ON produto.id_produto = carrinho_produto.id_produto AND id_carrinho = 1;