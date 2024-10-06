drop table if exists addresses cascade;
drop table if exists products cascade ;
drop table if exists users cascade ;
drop sequence if exists addresses_id_sequence;
drop sequence if exists product_id_sequence;
drop sequence if exists users_id_sequence;

create sequence addresses_id_sequence start with 1000 increment by 1;
create sequence product_id_sequence start with 1000 increment by 1;
create sequence users_id_sequence start with 1000 increment by 1;

create table addresses (
        zip integer not null,
        id bigint DEFAULT NEXT VALUE FOR addresses_id_sequence,
        user_id bigint,
        addr1 varchar(50),
        addr2 varchar(50),
        city varchar(30),
        country varchar(20),
        primary key (id)
);
create table products (
        id bigint DEFAULT NEXT VALUE FOR product_id_sequence,
        price numeric(5,2) not null,
        added_date timestamp(6),
        color varchar(10),
        name varchar(30),
        primary key (id)
);
create table users (
        reg_time TIMESTAMP WITH TIME ZONE,
        id bigint DEFAULT NEXT VALUE FOR users_id_sequence,
        name varchar(50),
        primary key (id)
);
alter table if exists addresses
       add constraint fk_addresses_user
       foreign key (user_id) 
       references users;
