create table produto(
	id serial primary key,
	nome varchar,
	preco float,
	qtdEstoque int
)

INSERT INTO produto (nome, preco, qtdEstoque) VALUES ('Laptop', 999.99, 50);
INSERT INTO produto (nome, preco, qtdEstoque) VALUES ('Smart TV', 699.99, 30);
INSERT INTO produto (nome, preco, qtdEstoque) VALUES ('Fones de Ouvido sem Fio', 149.99, 100);
INSERT INTO produto (nome, preco, qtdEstoque) VALUES ('Câmera Digital', 399.99, 20);
INSERT INTO produto (nome, preco, qtdEstoque) VALUES ('Console de Videogame', 299.99, 50);
