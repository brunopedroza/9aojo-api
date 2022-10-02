create table localehoraos
(
    id        bigint auto_increment
        primary key,
    data_hora datetime(6) null,
    latitude  double      null,
    longitude double      null
);

create table ordens_servico
(
    id                    bigint auto_increment
        primary key,
    id_prestador          bigint not null,
    fim_atendimento_id    bigint null,
    inicio_atendimento_id bigint null,
    constraint FK_fim_atendimento_id
        foreign key (fim_atendimento_id) references localehoraos (id),
    constraint FK_inicio_atendimento_id
        foreign key (inicio_atendimento_id) references localehoraos (id)
);

create table ordens_servico_servicos
(
    ordem_servico_id bigint not null,
    servicos_id      bigint not null,
    constraint FK_ordens_servico_id_servicos
        foreign key (ordem_servico_id) references ordens_servico (id),
    constraint FK_servicos_id_ordens_servico
        foreign key (servicos_id) references servicos (id)
);

