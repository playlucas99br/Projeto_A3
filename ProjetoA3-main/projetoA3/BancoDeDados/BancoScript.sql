create database escola;
use escola;

create table ListaEspera(
    ID integer primary key auto_increment,
    Alunos varchar(50) not null,
    Turmas varchar(50) not null,
    Matricula varchar(50) not null
);

create table Cursos(
    ID integer primary key auto_increment,
    Nome varchar(50) not null,
    CargaHoraria integer not null,
    DescricaoSobre varchar(400) not null
);

create table Salas(
    ID integer primary key auto_increment,
    Local varchar(50) not null,
    CapacidadeTotal integer not null
);

create table Professor(
    ID integer primary key auto_increment,
    Nome varchar(50) not null,
    Sobrenome varchar(20)  not null,
    CPF varchar(20) not null,
    Fone varchar(20) not null,
    Endereco varchar(100) not null,
    CEP integer not null
);

create table Aluno(
    RA INTEGER primary key auto_increment,
    Nome varchar(50) not null,
    CPF varchar(20) not null,
    Sobrenome varchar(20)  not null,
    Fone varchar(20) not null,
    Endereco varchar(100) not null,
    CEP INTEGER not null,
    Curso INTEGER NOT NULL,
    FOREIGN KEY (Curso) REFERENCES cursos(ID)
);

CREATE TABLE turmas (
    ID integer PRIMARY KEY AUTO_INCREMENT,
    Semestre integer NOT NULL,
    Ano integer NOT NULL,
    Curso integer NOT NULL,
    Sala integer NOT NULL,
    Professor integer NOT NULL,
    Hora VARCHAR(50) NOT NULL,
    FOREIGN KEY (Curso) REFERENCES cursos(ID),
    FOREIGN KEY (Sala) REFERENCES salas(ID),
    FOREIGN KEY (Professor) REFERENCES professor(ID)
);

create table matricula(
    turma integer not null,
    alunos integer not null,
    FOREIGN KEY(turma) REFERENCES turmas(ID),
    FOREIGN KEY(alunos) REFERENCES aluno(RA),
    PRIMARY KEY (turma, alunos)
);