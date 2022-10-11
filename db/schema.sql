-- Dupla: Lucas Portela Lopes e Vinícius Matté Medeiros.

DROP TABLE IF EXISTS cliente CASCADE;
DROP TABLE IF EXISTS vendedor CASCADE;
DROP TABLE IF EXISTS endereco CASCADE;
DROP TABLE IF EXISTS cliente_vendedor_endereco CASCADE;
DROP TABLE IF EXISTS cartao_credito CASCADE;
DROP TABLE IF EXISTS cartao_credito_cliente CASCADE;
DROP TABLE IF EXISTS transportadora CASCADE;
DROP TABLE IF EXISTS produto CASCADE;
DROP TABLE IF EXISTS categoria_produto CASCADE;
DROP TABLE IF EXISTS avaliacao CASCADE;
DROP TABLE IF EXISTS pedido_produto CASCADE;
DROP TABLE IF EXISTS pedido CASCADE;
DROP TABLE IF EXISTS carrinho_produto CASCADE;
DROP TABLE IF EXISTS carrinho CASCADE;
DROP TABLE IF EXISTS cupom CASCADE;

CREATE TABLE cupom (
  id_cupom INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  codigo VARCHAR(25) NOT NULL,
  porcentagem_desconto DECIMAL(3,2)
);

CREATE TABLE carrinho (
  id_carrinho INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  valor_total DECIMAL(8,2),
  id_cupom INT,
  FOREIGN KEY (id_cupom) REFERENCES cupom (id_cupom)
);

CREATE TABLE cliente (
  id_cliente INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(16) NOT NULL,
  cpf CHAR(11) NOT NULL,
  id_carrinho INT NOT NULL,
  FOREIGN KEY (id_carrinho) REFERENCES carrinho (id_carrinho)
);

CREATE TABLE vendedor (
  id_vendedor INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(16) NOT NULL,
  cnpj CHAR(15) NOT NULL,
  nota DECIMAL(2,1)
);

CREATE TABLE endereco (
  id_endereco INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  logradouro VARCHAR(255) NOT NULL,
  numero INT NOT NULL,
  cidade VARCHAR(55) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  complemento VARCHAR(15)
);

CREATE TABLE cliente_vendedor_endereco (
  id_cliente_vendedor_endereco INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  id_cliente INT,
  id_vendedor INT,
  id_endereco INT,
  FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
  FOREIGN KEY (id_vendedor) REFERENCES vendedor (id_vendedor),
  FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco)
);

CREATE TABLE cartao_credito (
  id_cartao_credito INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  nome VARCHAR(255) NOT NULL,
  numero VARCHAR(255) NOT NULL,
  data_vencimento DATE NOT NULL,
  cvv VARCHAR(3) NOT NULL
);

CREATE TABLE cartao_credito_cliente (
  id_cartao_credito_cliente INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  id_cartao_credito INT NOT NULL,
  id_cliente INT NOT NULL,
  FOREIGN KEY (id_cartao_credito) REFERENCES cartao_credito (id_cartao_credito),
  FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

CREATE TABLE transportadora (
  id_transportadora INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  nome VARCHAR(255) NOT NULL
);

CREATE TABLE categoria_produto (
  id_categoria_produto INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  nome VARCHAR(55) NOT NULL,
  descricao VARCHAR(255) NOT NULL
);

CREATE TABLE produto (
  id_produto INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  nome VARCHAR(255) NOT NULL,
  imagem_url TEXT NOT NULL,
  descricao TEXT NOT NULL,
  estoque INT NOT NULL,
  preco DECIMAL(8,2) NOT NULL,
  id_vendedor INT NOT NULL,
  id_categoria INT NOT NULL,
  FOREIGN KEY (id_vendedor) REFERENCES vendedor (id_vendedor),
  FOREIGN KEY (id_categoria) REFERENCES categoria_produto (id_categoria_produto)
);

CREATE TABLE avaliacao (
  id_avaliacao INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  nota DECIMAL(2, 1) NOT NULL,
  imagem_url TEXT,
  comentario TEXT,
  id_produto INT NOT NULL,
  FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
);

CREATE TABLE pedido (
  id_pedido INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  data_realizacao TIMESTAMP NOT NULL,
  id_cliente INT NOT NULL,
  id_transportadora INT NOT NULL,
  id_endereco INT NOT NULL,
  id_cartao_credito INT NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
  FOREIGN KEY (id_transportadora) REFERENCES transportadora (id_transportadora),
  FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco),
  FOREIGN KEY (id_cartao_credito) REFERENCES cartao_credito (id_cartao_credito)
);

CREATE table carrinho_produto (
  id_carrinho_produto INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  id_carrinho INT NOT NULL,
  id_produto INT NOT NULL,
  FOREIGN KEY (id_carrinho) REFERENCES carrinho (id_carrinho),
  FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
);

CREATE table pedido_produto (
  id_pedido_produto INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  id_pedido INT NOT NULL,
  id_produto INT NOT NULL,
  FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido),
  FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
);

