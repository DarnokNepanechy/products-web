drop table if exists roles;

create table roles (
                       id  bigserial not null,
                       name varchar(255),
                       primary key (id)
);

drop table if exists users;

create table users (
                       id  bigserial not null,
                       password varchar(255),
                       username varchar(255),
                       primary key (id)
);

drop table if exists users_roles;

create table users_roles (
                             user_id int8 not null,
                             roles_id int8 not null,
                             primary key (user_id, roles_id)
);

alter table users_roles
    add constraint FKa62j07k5mhgifpp955h37ponj
        foreign key (roles_id)
            references roles;

alter table users_roles
    add constraint FK2o0jvgh89lemvvo17cbqvdxaa
        foreign key (user_id)
            references users;

insert into roles(id, name)
values
       (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

insert into users(id, password, username)
values
       (1, '$2a$12$Kgne0rNl5W0zQ/dzjEXaQ.D6EyA5HoyUaEJS5S0RyYc9WmF/4iO9m', 'user'),
       (2, '$2a$12$e/a6dcVnla6iXEDGUyv86uzlhQoHhCjaIRJzI6oSFauFspMv4uaxa', 'admin');

insert into users_roles(user_id, roles_id)
values
       (1, 2),
       (2, 1);