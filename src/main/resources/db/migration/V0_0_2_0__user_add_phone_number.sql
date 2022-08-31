alter table if exists "user"
    add column if not exists phone_number varchar(255) default null;
