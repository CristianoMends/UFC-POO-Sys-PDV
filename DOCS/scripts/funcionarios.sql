drop table funcionario;
-- Tabela principal para todos os funcionários
CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR,
    endereco VARCHAR,
    email VARCHAR,
    cpf VARCHAR,
    cargo VARCHAR
);

-- Tabela para administradores (referencia a tabela principal funcionario)
CREATE TABLE administrador (
    id_funcionario INT PRIMARY KEY REFERENCES funcionario(id),
    usuario VARCHAR,
    senha VARCHAR
);

-- Inserir administrador
INSERT INTO funcionario (nome, endereco, email, cpf, cargo)
VALUES ('Cristiano Mendes', 'Basilio Pinto, 123', 'cristiano@gmail.com', '123.456.789-00', 'Administrador');

WITH administrador_id AS (
    SELECT id FROM funcionario WHERE cpf = '123.456.789-00'
)
INSERT INTO administrador (id_funcionario, usuario, senha)
SELECT id, 'usuarioAdmin', 'senhaAdmin' FROM administrador_id;

-- Inserir vendedores
INSERT INTO funcionario (nome, endereco, email, cpf, cargo)
VALUES ('João Silva', 'Rua das Vendas, 456', 'joao.silva@example.com', '111.222.333-44', 'vendedor');

INSERT INTO funcionario (nome, endereco, email, cpf, cargo)
VALUES ('Maria Oliveira', 'Avenida das Vendas, 789', 'maria.oliveira@example.com', '555.666.777-88', 'vendedor');

INSERT INTO funcionario (nome, endereco, email, cpf, cargo)
VALUES ('Carlos Santos', 'Travessa das Vendas, 101', 'carlos.santos@example.com', '999.888.777-66', 'vendedor');

