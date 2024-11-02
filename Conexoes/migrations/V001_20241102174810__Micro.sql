-- Criação do Banco de Dados
CREATE DATABASE empresa_climatizacao;

-- Conecte-se ao banco de dados
\c empresa_climatizacao;

-- Tabela para Clientes
CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    endereco VARCHAR(150)
);

-- Tabela para Funcionários
CREATE TABLE funcionarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    salario NUMERIC(10, 2),
    cargo VARCHAR(50) -- Valores possíveis: 'Gerente', 'Técnico'
);

-- Tabela para Serviços
CREATE TABLE servicos (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(150) NOT NULL,
    valor NUMERIC(10, 2),
    tipo_servico VARCHAR(50) -- Valores possíveis: 'Instalação', 'Manutenção', 'Suporte Técnico'
);
