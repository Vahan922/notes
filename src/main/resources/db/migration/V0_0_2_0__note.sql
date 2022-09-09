create table if not exists note
(
    id           bigint       not null
        constraint note_pkey primary key,
    created_time time,
    note         varchar(255),
    title        varchar(255) not null,
    updated_time time,
    user_id      bigint       not null
        constraint note_fkey
            references "user"
);

create sequence if not exists note_sequence
    start with 1
    increment by 1;