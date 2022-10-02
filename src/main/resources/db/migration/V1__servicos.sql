create table servicos
(
    id        bigint auto_increment
        primary key,
    categoria varchar(300) not null,
    descricao varchar(300) not null,
    nome      varchar(100) not null
);

INSERT INTO servicos (categoria, descricao, nome) VALUES ('Geladeira', 'Manutenção realizada na casa do cliente sem troca de peças', 'Manutenção Periódica');
INSERT INTO servicos (categoria, descricao, nome) VALUES ('Fogão', 'Troca do cabo de alimentação de energia danificado', 'Reparo Elétrico');
INSERT INTO servicos (categoria, descricao, nome) VALUES ('Máquina de Lavar', 'Instalação do utensílio na casa do cliente', 'Instalação');
INSERT INTO servicos (categoria, descricao, nome) VALUES ('Geladeira', 'Substituição do motor', 'Troca de Peça');
INSERT INTO servicos (categoria, descricao, nome) VALUES ('Microondas', 'Troca do cabo de alimentação de energia danificado', 'Reparo Elétrico');
INSERT INTO servicos (categoria, descricao, nome) VALUES ('Filtro de Água', 'Substituição de filtro', 'Manutenção');
