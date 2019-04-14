create database torneoFrescas;
use torneoFrescas;
create table winners (
    id_winner int unsigned auto_increment,
    name varchar(50),
    age int unsigned,
    weight int unsigned,
    special_ability double unsigned,
    consumed_quantity double unsigned,
    human_type varchar(10),
    constraint pk_winners PRIMARY KEY (id_winner)
);
