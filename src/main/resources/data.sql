insert into tb_editora(editora_id, nome_editora, cidade_editora, ano_fundacao) values (1, 'pau no meu cu', 'Sao Paulo', 2002);
insert into tb_editora(editora_id, nome_editora, cidade_editora, ano_fundacao) values(2, 'Campus', 'Rio de Janeiro', 2000);
insert into tb_editora(editora_id, nome_editora, cidade_editora, ano_fundacao) values(3, 'Saraveira', 'São Paulo', 1950);
insert into tb_editora(editora_id, nome_editora, cidade_editora, ano_fundacao) values(4, 'Moderna', 'Rio de Janeiro', 1964);
insert into tb_editora(editora_id, nome_editora, cidade_editora, ano_fundacao) values(5, 'Bookman', 'Florianópolis', 2002);
insert into tb_editora(editora_id, nome_editora, cidade_editora, ano_fundacao) values(6, 'Atlas', 'Porto Alegre', 1994);
insert into tb_editora(editora_id, nome_editora, cidade_editora, ano_fundacao) values(7, 'Pearson', 'São Paulo', 2010);


insert into tb_livro(livro_id, titulo, data_publicacao, numero_paginas, preco, editora_id)
values (1,'Sobre Mouses e Homens', '1954-11-08', 100, 11.00, 1);
insert into tb_livro(livro_id, titulo, data_publicacao, numero_paginas, preco, editora_id)
values (2,'Um Estranho no Ninho', '1973-11-08', 200, 15.00, 2);
insert into tb_livro(livro_id, titulo, data_publicacao, numero_paginas, preco, editora_id)
values (3,'Por Quem os Sinos Dobram', '1932-11-08', 100, 13.00, 3);
insert into tb_livro(livro_id, titulo, data_publicacao, numero_paginas, preco, editora_id)
values (4,'Guerra e Paz', '1955-11-08', 140, 15.00, 4);
insert into tb_livro(livro_id, titulo, data_publicacao, numero_paginas, preco, editora_id)
values (5,'As Vinhas da Ira', '1955-11-08', 300, 16.00, 5);
insert into tb_livro(livro_id, titulo, data_publicacao, numero_paginas, preco, editora_id)
values (6,'Padrões de Design', '1996-11-08', 180, 14.00, 6);
insert into tb_livro(livro_id, titulo, data_publicacao, numero_paginas, preco, editora_id)
values (7,'Um Conto de Duas Cidades', '1943-11-08', 400, 15.00, 7);


insert into tb_autor(autor_id, primeiro_nome, ultimo_nome, pais) values (1, 'Orson', 'Welles', 'Inglaterra');
insert into tb_autor(autor_id, primeiro_nome, ultimo_nome, pais) values (2, 'Aldous', 'Huxley', 'Inglaterra');
insert into tb_autor(autor_id, primeiro_nome, ultimo_nome, pais) values (3, 'Leo', 'Tolstoi' , 'Russia');
insert into tb_autor(autor_id, primeiro_nome, ultimo_nome, pais) values (4, 'Sérgio', 'Ludicibus', 'Brasil');
insert into tb_autor(autor_id, primeiro_nome, ultimo_nome, pais) values (5, 'Harvey', 'Deitel', 'Estados Unidos');
insert into tb_autor(autor_id, primeiro_nome, ultimo_nome, pais) values (6, 'Paul', 'Deitel', 'Estados Unidos');

insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (1, 1);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (2, 2);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (3, 4);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (4, 5);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (5, 3);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (6, 3);

