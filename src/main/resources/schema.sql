create table customer (
    id           int auto_increment,
    first_name   varchar(255) not null,
    last_name    varchar(255) not null,
    address      varchar(255) not null,
    phone_number varchar(255) not null,
    email        varchar(255) not null
);