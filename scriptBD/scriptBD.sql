create database loja;

use loja;

create table funcionarios (
	id int not null auto_increment,
	nome varchar(100) not null,
	endereco varchar(150) not null,
	telefone varchar(11) not null,
primary key(id));


create table vendas (
	id int not null auto_increment,
	valor float not null,
	descricao varchar(45) not null,
	idCliente int not null,
	idFuncionario int not null,
primary key(id);


create table clientes (
	id int not null auto_increment,
	nome varchar(50) not null,
	endereco varchar(100) not null,
	telefone varchar(11) not null,
	cpf varchar(11) not null,
primary key(id));

alter table vendas add foreign key (idCliente) references clientes (id);

alter table vendas add foreign key (idFuncionario) references funcionarios (id);

