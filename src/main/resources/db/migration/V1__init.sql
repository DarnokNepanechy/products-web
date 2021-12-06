drop table if exists products;

CREATE TABLE products (
    id serial,
    title varchar(100),
    price int
                      );

insert into products(title, price)
values
       ('Bread', 50),
       ('Milk', 100),
       ('Cheese', 350),
       ('Red Vine', 850),
       ('Coconut', 250),
       ('Apple Juice', 100),
       ('Banana', 70),
       ('Chicken', 390),
       ('Fish', 350),
       ('Tea', 150),
       ('Coffee', 250),
       ('Potato', 50),
       ('Carrot', 20),
       ('Garbage', 50),
       ('Chocolate', 90);