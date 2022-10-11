INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);
INSERT INTO carrinho (valor_total, id_cupom) VALUES (null, null);

INSERT INTO cliente (nome,email,senha,cpf,id_carrinho)
VALUES
  ('Eduarda Lavínia da Cruz', 'eduardalaviniadacruz@hotmailo.com', 'mxo4q9nkB2', '95433637654', 1),
  ('Raimundo Samuel Levi Ribeiro', 'raimundo_samuel_ribeiro@yande.com.br', '22NRuwIHGL', '09410246601', 2),
  ('Lúcia Aline Aragão', 'luciaalinearagao@vemter.com.br', 'zJ4trLfOSB', '41733844830', 3),
  ('Madison Tillman','madison.tillman@hotmail.org','WYQ41JMS3EN','26524223721',4),
  ('Laurel Graham','laurel.graham@protonmail.net','LWQ54SZQ3MC','39283136497',5),
  ('Beck Rice','beck.rice@google.com','BDX61TIN3NT','63222246491',6),
  ('Stacy Berger','stacy.berger@outlook.com','HFD31JZM7RV','80027319605',7),
  ('Alyssa Tate','alyssa.tate@outlook.ca','LPO01CQQ6KV','25169244653',8),
  ('Ralph Leonard','ralph.leonard@protonmail.org','MFX86TEZ9HT','28772806152',9),
  ('Ciaran Mclaughlin','ciaran.mclaughlin@icloud.net','MTG25VST8KS','64253651343',10),
  ('Kaitlin Hensley','kaitlin.hensley@icloud.couk','ENY83JNB5MM','58932752283',11),
  ('Calvin Taylor','calvin.taylor@yahoo.ca','ADL51UWM5IA','25832111714',12),
  ('Charissa Pace','charissa.pace@yahoo.com','LOL91HRN7MY','42186273252',13);
  
INSERT INTO vendedor (nome, email, senha, cnpj)
VALUES
  ('Martin Sérgio Benedito Assunção', 'martin_assuncao@jci.com', 'bWxp8m7nDC', '26333554000102'),
  ('Bianca Rosa Almada', 'bianca-almada72@nextel.com.br', 'eR8XCn3STn', '82173281000149'),
  ('Lucca Kevin Assis', 'lucca_assis@ceuazul.ind.br', 'gl9O2NHRxt', '00995862000100'),
  ('Lavinia Madden','lavinia.madden@google.net','OPX97TYP6MR','28239447764128'),
  ('Grace Kramer','grace.kramer@yahoo.com','KMX83IAP3BQ','57585112584347'),
  ('Elmo Martinez','elmo.martinez@aol.com','YIJ16FKG3CQ','93278050754544'),
  ('Zephania Mckay','zephania.mckay@yahoo.com','WPB95RWE2MB','26942219101330'),
  ('Nell Marsh','nell.marsh@outlook.com','GCQ16LSJ2PK','07612497513822'),
  ('Reuben Aguilar','reuben.aguilar@hotmail.com','IUX32VBN0RL','72147660238672'),
  ('Samson Kramer','samson.kramer@protonmail.com','MCG93NSQ2HJ','16225423288424'),
  ('Joel Sanford','joel.sanford@uol.com','gUN29.kI7OP','18165366862248'),
  ('Conan Carver','conan.carver@icloud.com','IUV25RVT0GF','78654298347822'),
  ('Raya Gilliam','raya.gilliam@protonmail.com','PQN17MIT8BN','52915529742474');
    
INSERT INTO endereco (logradouro, numero, cidade, uf, complemento)
VALUES
  ('Travessa Santa Lúcia II', 296, 'Parnaíba', 'PI', null),
  ('Praça dos Imigrantes', 133, 'São Caetano do Sul', 'SP', '305'),
  ('Rua Florianópolis', 690, 'Cacoal', 'RO', null),
  ('Rua Angelo Vicentim', 307,'Campinas', 'SP', '348'),
  ('Avenida Paulista', 471,'São Paulo', 'SP', '551'),
  ('Estrada Francisco da Cruz Nunes', 977, 'Niterói', 'RJ', '515'),
  ('Avenida Priscila Dutra', 894, 'Lauro de Freitas', 'BA', '987'),
  ('Avenida Severino Ballesteros', 687, 'Contagem', 'MG', null),
  ('Rua da Graça', 675, 'Juazeiro', 'BA', '194'),
  ('Rua José Bonifácio', 639, 'Diadema', 'SP', '929'),
  ('Avenida Francisco Sá', 212, 'Caucaia', 'CE', '692'),
  ('Rodovia Celso Garcia', 317, 'Londrina', 'PR', '444'),
  ('Rua Darcílio Vanderlei da Nóbrega', 811,'Patos', 'PB', '572'),
  ('Avenida Coronel José Lobo', 140,'Paranaguá', 'PR', null),
  ('Avenida São João', 677, 'Juazeiro', 'BA', '313'),
  ('Avenida Plácido Aderaldo Castelo', 159, 'Juazeiro do Norte', 'CE', '270'),
  ('Rua Padre Manoel Mariano', 498, 'Cajazeiras', 'PB', '680'),
  ('Avenida Universitária', 982, 'Criciúma', 'SC', null);  

INSERT INTO cliente_vendedor_endereco (id_cliente, id_vendedor, id_endereco)
  VALUES 
  (1, null, 1),
  (null, 2, 2),
  (null, 1, 2),
  (2, null, 3),
  (null, 3, 4),
  (null, 1, 4),
  (3, null, 5),
  (null, 4, 6),
  (4, null, null),
  (null, 5, 8),
  (5, null, 9),
  (null, 6, 10),
  (6, null, null),
  (null, 7, 12),
  (7, null, 13),
  (8, null, 14),
  (null, 8, 15),
  (9, null, null),
  (null, 9, 17),
  (10, null, null);  
  
INSERT INTO cartao_credito (nome, numero, data_vencimento, cvv)
VALUES
  ('JOAO J OAOJ', '5591 7624 1688 5845', '07/06/2023', '803'),
  ('MARIA M AIRAM', '5307 0454 0385 5798', '07/01/2023', '756'),
  ('FULANO F ONALUF', '5556 1480 1426 8340', '07/02/2024', '599'),
  ('Tate Pate','4929 8725 6444 7183','23/01/2028','411'),
  ('Marcia Webb','5428 2351 3684 9292','07/10/2024','481'),
  ('Emerson Byers','4539 7866 5898 3261','21/11/2025','164'),
  ('Deborah House','4175 5839 2378 5848','13/05/2030','796'),
  ('Althea Avery','4716 8488 3758 7374','15/11/2029','461'),
  ('Britanney Erickson','4485 6677 5591 2466','26/06/2023','378'),
  ('Lael Huber','4539 7774 4148 2885','01/04/2029','976'),
  ('Harding Mcknight','5282 8547 2114 6644','08/07/2022','343'),
  ('Wade Myers','5478 2386 7993 4637','06/02/2024','652'),
  ('Kermit Horn','4024 0071 7822 5584','30/06/2031','374'),
  ('Chiquita Hurst','4485 7692 3984 7761','13/01/2023','461'),
  ('Aimee Foreman','5413 8287 3786 2636','21/05/2027','534'),
  ('Hasad Phelps','5143 8227 4957 6273','18/02/2022','675'),
  ('Hunter Roth','5525 4585 5623 2888','16/12/2026','171'),
  ('Merritt Patton','5386 7531 7444 4867','07/11/2024','615');
  
INSERT INTO cartao_credito_cliente (id_cartao_credito, id_cliente)
  VALUES 
  (1, 1),
  (2, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 5),
  (6, 6),
  (7, 7),
  (8, 8),
  (9, 9),
  (10, 10),
  (11, 11),
  (12, 12),
  (13, 13);

INSERT INTO transportadora (nome)
  VALUES 
  ('Transportadora Rápida'),
  ('Transportadora Hoje'),
  ('Transportadora Flash'),
  ('Transportadora ABC'),
  ('Tranportadora Cezar');

INSERT INTO categoria_produto (nome, descricao)
  VALUES 
  ('Computadores e Acessórios', 'Itens de Informática'),
  ('Beleza', 'Itens para cuidados pessoais.'),
  ('Automóveis', 'Itens para customização e manutenção de veículos.'),
  ('Celulares e Dispositivos', 'Smartphones e acessórios');

INSERT INTO produto (nome, imagem_url, descricao, estoque, preco, id_vendedor, id_categoria)
  VALUES 
  ('IPhone 8 Plus', 'https://imgs.casasbahia.com.br/50005208/1xg.jpg?imwidth=500', 'Produto original, confia.', 432, 1899, 1, 4),
  ('IPhone 11 64 GB', 'https://cf.shopee.com.br/file/52f6be80f937f75573cc808508fdc4de', 'Apple Iphone 11', 1, 4699, 1, 4),
  ('IPhone 12 128GB - Preto', 'https://cf.shopee.com.br/file/88b829a1badf462d46c42bbacbd3c2b5','Apple IPhone 12 128GB', 4, 6099, 1, 4),
  ('Galaxy S20','https://cf.shopee.com.br/file/ccabd150d8a1fae56948e9ba93d40abb', 'Samsung Galaxy S20', 67, 2099, 1, 4),
  ('Sachê de Mel Capilar', 'https://cf.shopee.com.br/file/d2e6b7b839d9491e4c3e8415d5bb9e74', 'O MEL CAPILAR é enriquecido com mel e geleia real que possuem propriedades nutritivas que reconstroem a fibra capilar danificada pela ação química, conferindo um brilho radiante.', 22, 7, 2, 2),
  ('Kit 2 Pneu Roda Maciça Para Carrinho De Carga', 'https://http2.mlstatic.com/D_NQ_NP_706983-MLB42334066154_062020-O.webp', 'NÃO FURA, NÃO ESVAZIA, NÃO PRECISA DE MANUTEÇÃO', 64, 139.90, 3, 3),
  ('Cabo Chupeta Para Bateria De Carro Com 2,5m 200amp', 'https://cf.shopee.com.br/file/a82b8259f7954d3a98a4e8e616f906a9_tn', 'Indicado para carros de passeios e veículos de frotas', 54, 29.90, 3, 3),
  ('Som Para Carro Automotivo', 'https://cf.shopee.com.br/file/826597800f4f04899cbd9fecd683fa7b', 'Som Para Carro Automotivo Com Bluetooth Mp3 Usb 2 Ano Garantia', 98, 65.90, 3, 3),
  ('Kit Sensor automotivo Estacionamento', 'https://cf.shopee.com.br/file/06ae812e1ad6dc2d38f9136ce25a3ba6', 'Kit Sensor automotivo Estacionamento Ré 4 Pontos traseira Preto prata branco vermelho', 7, 59.90, 3, 3),
  ('Touca De Cetim', 'https://cf.shopee.com.br/file/3cfc76adf0e7b2acc92966483f9424da', 'Touca De Cetim AntiFrizz', 11, 10.90, 4, 2),
  ('Lixa Boomerang Preta', 'https://cf.shopee.com.br/file/cc83d6c6f77d87f0dd4ba4046404c20d', 'Lixa Boomerang Preta (100/180) - Honey Girl', 25, 2.50, 4, 2),
  ('Sabonete DOVE Original', 'https://cf.shopee.com.br/file/b03260478031d479dc0a38e5f46bdb7c', 'Sabonete DOVE Original 90g - 1/4 hidratante', 243, 4.99, 4, 2),
  ('Mouse Com Fio Usb Multilaser', 'https://cf.shopee.com.br/file/b52ff4b9304684d50bac0a8635ffa619', 'Mouse Com Fio Usb Multilaser Notebook Computador Pc 1200dpi', 3, 14.90, 5, 1),
  ('Pen drive 16gb Multilaser', 'https://cf.shopee.com.br/file/eb48177b45db5bb1db1effdfb48d2083', 'Pen drive 16gb Multilaser Twist PD588 Original', 2, 19.50, 5, 1),
  ('Repetidor Amplificador De Sinal Wifi', 'https://cf.shopee.com.br/file/4b5d3b4828b9428c99c15354362f6d7b', 'Repetidor Amplificador De Sinal Wifi 600/mbps Ultra Rápido Anatel', 7, 50.88, 5, 1),
  ('Celular Xiaomi Redmi Note 8', 'https://cf.shopee.com.br/file/1833bc69d52867c6d57b6d881837c111_tn', 'Celular Xiaomi Redmi Note 8 Dual SIM 64 GB 4GB RAM - NOVO LACRADO', 15, 1380, 6, 4),
  ('Suporte Celular Gps Veicular', 'https://cf.shopee.com.br/file/85b983e6d753db65be10fbbf44a05592', 'Suporte Celular Gps Veicular Automotivo Ventosa Vidro ANJ1008', 12, 18.99, 7, 3),
  ('Kingston A400 SSD Sata 3', 'https://cf.shopee.com.br/file/89b716787ede3704d6cf654a28b75c1b', 'Kingston A400 SSD Sata 3 Solid State Drive 2.5 Inch - 30 /60/120 / 240 / 480gb', 21, 68, 8, 2);

INSERT INTO cupom (codigo, porcentagem_desconto)
  VALUES 
  ('40OFF', 0.4),
  ('FRETEGRATIS1', null),
  ('10OFF', 0.1);

INSERT INTO avaliacao (nota, imagem_url, comentario, id_produto)
  VALUES 
  (4.8, null, 'Muito bom, mas é falso.', 1),
  (5, 'https://previews.123rf.com/images/badmanproduction/badmanproduction1207/badmanproduction120700174/14381950-bald-guy-blinking.jpg', 'Horrível, fiquei careca, mas gostei.', 2),
  (0, null, 'Furou tudo.', 3);

INSERT INTO pedido (data_realizacao, id_cliente, id_transportadora, id_endereco, id_cartao_credito)
  VALUES (current_timestamp, 1, 1, 1, 1);
INSERT INTO pedido (data_realizacao, id_cliente, id_transportadora, id_endereco, id_cartao_credito)
  VALUES (current_timestamp, 2, 2, 3, 2);
INSERT INTO pedido (data_realizacao, id_cliente, id_transportadora, id_endereco, id_cartao_credito)
  VALUES (current_timestamp, 3, 3, 5, 3);

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

INSERT INTO pedido_produto (id_pedido, id_produto)
  VALUES (1, 1);
INSERT INTO pedido_produto (id_pedido, id_produto)
  VALUES (1, 2);
INSERT INTO pedido_produto (id_pedido, id_produto)
  VALUES (1, 3);
INSERT INTO pedido_produto (id_pedido, id_produto)
  VALUES (2, 1);
INSERT INTO pedido_produto (id_pedido, id_produto)
  VALUES (3, 1);

-- exemplo select da relação produto-carrinho com a tabela intermediária
-- select * from produto JOIN carrinho_produto ON produto.id_produto = carrinho_produto.id_produto AND id_carrinho = 1;