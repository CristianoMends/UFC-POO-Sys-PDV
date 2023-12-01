INSERT INTO produto (nome, preco, qtdEstoque, categoria, imagem)
VALUES ('Playstation 5', 3719.00, 20, 'Console', 'https://m.media-amazon.com/images/I/51+qnZm7V7L._AC_SL1000_.jpg'),
	   ('Playstation 4', 3909.99,20,'Console','https://m.media-amazon.com/images/I/61Jd6PKi6SL._AC_SL1000_.jpg'),
	   ('Notebook Nitro 5', 4999.00, 20, 'Notebook','https://m.media-amazon.com/images/I/61wxOWQ74kL._AC_SL1000_.jpg'),
	   ('Monitor Odyssey 27" 165Hz', 1039.99,20,'Monitor','https://m.media-amazon.com/images/I/51Cu-Uh2WrL._AC_SL1000_.jpg'),
	   ('PC Gamer I5 10400F RTX 3060', 4699.99,20,'Computador','https://m.media-amazon.com/images/I/61wWmawYBIL._AC_SL1500_.jpg'),
	   ('Spider-Man 2 - PlayStation 5', 313.11,20,'Game','https://m.media-amazon.com/images/I/81RfcW3Ml-L._AC_SL1500_.jpg'),
	   ('EA Sports FC 24 - PlayStation 5', 325.00,20,'Game','https://m.media-amazon.com/images/I/61+lZsNKGuL._AC_SL1020_.jpg'),
	   ('God of War Ragnarök - PlayStation 5', 349.90,20,'Game','https://m.media-amazon.com/images/I/8136lnf0n2L._AC_SL1500_.jpg');

-- Inserir funcionarios
INSERT INTO pessoa (nome, endereco, email, cpf)
VALUES
    ('Cristiano Mendes', 'Rua Basilio pinto', 'cristiano@gemail.com', '123.456.789-10'),
    ('Cristiano Ronaldo', 'Rua CR7', 'cr7@gemail.com', '111.111.111-11'),
    ('Airton da Silva', 'Rua 25 de março', 'airton@gemail.com', '222.222.222-22'),
    ('Piculino diogenes', 'Rua polo sul', 'diogenes@gemail.com', '333.333.333-33');

INSERT INTO funcionario (cargo, usuario, senha, idPessoa)
VALUES
    ('Administrador', 'cristiano', 'qwe123', 1),
    ('Vendedor', null, null, 2),
    ('Vendedor', null, null, 3),
    ('Vendedor', null, null, 4);
