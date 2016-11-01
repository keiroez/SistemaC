CREATE TABLE PACIENTE (

	 
     NOME VARCHAR (50) NOT NULL,
     RG VARCHAR(20) NOT NULL,
     CPF VARCHAR(20) UNIQUE,
     TELEFONE VARCHAR (20) NULL,
     ESTADO VARCHAR(20) NULL,
     CIDADE VARCHAR(30) NULL,
     BAIRRO VARCHAR (30) NULL,
     RUA VARCHAR (30) NULL,
     NUMERO INT NULL,
     
     PRIMARY KEY (CPF)
     
);


CREATE TABLE FUNCIONARIO (
	 
     NOME VARCHAR (50) NOT NULL,
     RG VARCHAR(20) NOT NULL,
     CPF VARCHAR(20) UNIQUE,
     TELEFONE VARCHAR (20) NULL,
     ESTADO VARCHAR(30) NULL,
     CIDADE VARCHAR(30) NULL,
     BAIRRO VARCHAR (30) NULL,
     RUA VARCHAR (30) NULL,
     NUMERO INT NULL,
     LOGIN VARCHAR(30) UNIQUE,
     SENHA VARCHAR (30) NULL,
     
     PRIMARY KEY (CPF)
  );
  
  

create table agendamento (

	dataConsulta Date,
    horario varchar(15),
    nomePaciente varchar(50),
    nomeFuncionario varchar(50),
    cpfPaciente varchar (15),
    cpfFuncionario varchar(15),
    primary key (dataConsulta, horario, nomePaciente, nomeFuncionario, cpfPaciente, cpfFuncionario),
    foreign key (cpfPaciente) references paciente(cpf),
    foreign key (cpfFuncionario) references funcionario(cpf)
);


create table prontuario(
	cpfPaciente varchar(15),
    historico varchar(500),
    dataConsulta Date,
    horario varchar(15),
    
    primary key (cpfPaciente, dataConsulta, horario),
    foreign key (cpfPaciente) references paciente (cpf)
);