create table if not exists cliente (
    id numeric primary key,
    saldo numeric not null check (saldo >= (limite * -1)),
    limite numeric not null
);

create table if not exists transacao (
    id numeric primary key,
    valor numeric,
    tipo char,
    descricao varchar,
    realizada_em Timestamp
);

insert into cliente (id,saldo,limite)
values
    (1,0,100000),
    (2,0,80000),
    (3,0,1000000),
    (4,0,10000000),
    (5,0,500000);