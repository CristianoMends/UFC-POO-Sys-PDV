
create table produto(
	id serial primary key,
	nome varchar,
	preco float,
	qtdEstoque int,
	categoria varchar,
	imagem varchar
);

create table produtoVenda(
	id serial primary key,
	qtd int,
	total float,
	idProduto int REFERENCES produto(id)
);

create table pessoa(
	id serial primary key,
	nome varchar,
	endereco varchar,
	email varchar,
	cpf varchar
);
create table funcionario(
	id serial primary key,
	cargo varchar,
	usuario varchar,
	senha varchar,
	idPessoa int references pessoa(id)
);

create table venda(
	id serial primary key,
	data date,
	idProdutoVenda int references produto(id),
	idCliente int references pessoa(id),
	idVendedor int references funcionario(id)
);
INSERT INTO produto (nome, preco, qtdEstoque, categoria, imagem)
VALUES ('Playstation 5', 3719.00, 20, 'console', 'https://m.media-amazon.com/images/I/51+qnZm7V7L._AC_SL1000_.jpg'),
	   ('Playstation 4', 3909.99,20,'console','https://m.media-amazon.com/images/I/61Jd6PKi6SL._AC_SL1000_.jpg');
