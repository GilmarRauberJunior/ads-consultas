create database consultorio;
use consultorio;

create table paciente(
	id int primary key auto_increment,
    nome varchar(40) not null,
    cpf varchar(15) unique not null,
    telefone varchar(15) not null,
    endereco varchar(40) not null,
    cep varchar(10) not null,
    bairro varchar(30) not null,
    complemento varchar(20),
    numero varchar(5) not null
);

create table ficha_paciente(
	id int primary key auto_increment,
    nome_Paciente varchar(40) not null,
    temp varchar(7) not null,
    pressao varchar(5) not null,
    local_Dor varchar(25) not null,
    inte_Dor varchar(2) not null,
    tipo_Dor varchar(15) not null,
    dura_Dor varchar(20) not null
);

create table rep(
	id int primary key auto_increment,
    nome varchar(40) not null,
    senha varchar(20) not null
);

create table medico(
	id int primary key auto_increment,
    nome varchar(40) not null,
    senha varchar(20) not null,
    crm varchar(9) not null unique
);

create table prontuario(
	id int primary key auto_increment,
    ficha varchar(500)
);

select * from rep;

insert into rep (nome, senha) values ("Valdir","12345");
insert into rep (nome, senha) values ("ADM123","ads1234");
insert into medico (nome, senha, crm) values ("Renato","12345","112233/RJ");
