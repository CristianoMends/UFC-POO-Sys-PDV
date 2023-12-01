CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR,
    preco FLOAT,
    qtdEstoque INT,
    categoria VARCHAR,
    imagem VARCHAR
);

CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR,
    endereco VARCHAR,
    email VARCHAR,
    cpf VARCHAR
);

CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY,
    cargo VARCHAR,
    usuario VARCHAR,
    senha VARCHAR,
    idPessoa INT REFERENCES pessoa(id)
);

CREATE TABLE venda (
    id SERIAL PRIMARY KEY,
    data DATE,
	metodo varchar,
	total float,
    idCliente INT REFERENCES pessoa(id),
    idVendedor INT REFERENCES funcionario(id)
);


