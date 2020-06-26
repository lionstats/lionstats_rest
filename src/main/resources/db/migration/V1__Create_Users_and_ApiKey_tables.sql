CREATE TABLE application_user(
    id bigserial primary key,
    email text null,
    username varchar(1024) not null,
    password bytea not null,
    created_at timestamp default now() not null,
    updated_at timestamp default now() not null,
    last_logged_in timestamp null
);

CREATE UNIQUE INDEX unique_email_index On application_user (email);
CREATE UNIQUE INDEX unique_username_index ON application_user (username);

CREATE TABLE guild_wars_api_key(
    id bigserial primary key,
    application_user_id bigint references application_user(id) on delete cascade not null,
    api_key varchar(72) not null,
    name text not null,
    created_at timestamp default now() not null,
    updated_at timestamp default now() not null,
    last_used timestamp null
);