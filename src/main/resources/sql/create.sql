CREATE DATABASE exchange;
create sequence hibernate_sequence start 1 increment 1;
create table change_money
(
    id                             int8   not null,
    cod_currency                   varchar(10),
    exchange_value                 float8 not null,
    sum_of_money_after_change      float8 not null,
    sum_of_money_should_to_convert float8 not null,
    currency_id                    int8,
    primary key (id)
);
create table currency
(
    id             int8   not null,
    code_currency  varchar(10),
    date           date,
    exchange_value float8 not null,
    rate           int4   not null,
    primary key (id)
);
create table currency_change_money
(
    currency_id     int8 not null,
    change_money_id int8 not null
);
create table numerar
(
    id             int8   not null,
    exchange_value varchar(10),
    sum_of_money   float8 not null,
    primary key (id)
);
alter table if exists currency_change_money add constraint UK_gxlrfid2ke1a1x5jrkd44txio unique (change_money_id);
alter table if exists change_money add constraint FK1emp8o2w23ao7wi8bvfpse05h foreign key (currency_id) references currency;
alter table if exists currency_change_money add constraint FKdiwv6kqlvconbrg8drwawvr6 foreign key (change_money_id) references change_money;
alter table if exists currency_change_money add constraint FKrf4y67vh7x8ggru7assmbpsa8 foreign key (currency_id) references currency;
