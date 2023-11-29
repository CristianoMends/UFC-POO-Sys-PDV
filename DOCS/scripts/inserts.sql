INSERT INTO produto (nome, preco, qtdEstoque, categoria, imagem)
VALUES ('Playstation 5', 3719.00, 20, 'console', 'https://m.media-amazon.com/images/I/51+qnZm7V7L._AC_SL1000_.jpg'),
	   ('Playstation 4', 3909.99,20,'console','https://m.media-amazon.com/images/I/61Jd6PKi6SL._AC_SL1000_.jpg');

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
