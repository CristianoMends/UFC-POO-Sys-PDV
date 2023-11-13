create table produto(
	id serial primary key,
	nome varchar,
	preco float,
	qtdEstoque int,
	categoria varchar,
	imagem varchar
);

INSERT INTO produto (nome, preco, qtdEstoque, categoria, imagem)
VALUES ('Playstation 5', 3719.00, 20, 'console', 'https://m.media-amazon.com/images/I/51+qnZm7V7L._AC_SL1000_.jpg'),
	   ('Playstation 4', 3909.99,20,'console','https://m.media-amazon.com/images/I/61Jd6PKi6SL._AC_SL1000_.jpg');
