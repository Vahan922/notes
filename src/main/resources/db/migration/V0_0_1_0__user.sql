create table if not exists "user"
(
    id            bigint       not null
        constraint user_pkey primary key,
    username      varchar(255) not null unique,
    first_name    varchar(255),
    last_name     varchar(255),
    password_hash varchar(255)
);

create sequence if not exists user_sequence
    start with 1
    increment by 1;