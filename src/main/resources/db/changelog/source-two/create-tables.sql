--liquibase formatted sql

-- changeset mk:create-travels
create table travels
(
    id integer primary key not null auto_increment
    ,travel_name varchar (200)
    ,number_of_seats integer
    ,number_occupied_seats integer
    ,price_per_seat integer
    ,start_date date
    ,finish_date date
);
-- rollback drop table travels

-- changeset mk:create-additional_items
 create table additional_items
 (
     id integer primary key not null auto_increment
     ,item_name varchar (200)
     ,price_per_seat integer
 );
-- rollback drop table additional_items

-- changeset mk:create-clients
create table clients
(
    id integer primary key not null auto_increment
    ,first_name varchar (200)
    ,last_name varchar (200)
    ,phone_number integer
    ,address  varchar (400)
);
-- rollback drop table clients

-- changeset mk:create-travel_orders
create table travel_orders
(
    id integer primary key not null auto_increment
    ,travel_id integer not null
    ,client_id integer not null
    ,number_of_seats integer
    ,order_date date
    ,payment_date date
    ,foreign key(travel_id) references travels(id)
    ,foreign key(client_id) references clients(id)
);
-- rollback drop table travel_orders

-- changeset mk:create-travel_additional_items
create table travel_additional_items
(
     id integer primary key not null auto_increment
     ,travel_id INTEGER NOT NULL
     ,FOREIGN KEY (travel_id) REFERENCES travels(id) ON DELETE CASCADE
     ,additional_item_id INTEGER NOT NULL
     ,FOREIGN KEY (additional_item_id) REFERENCES additional_items(id) ON DELETE CASCADE
);
-- rollback drop table travel_additional_items

-- changeset mk:create-travel_order_attendances
create table travel_order_attendances
(
     id integer primary key not null auto_increment
     ,travel_order_id INTEGER NOT NULL
     ,FOREIGN KEY (travel_order_id) REFERENCES travel_orders(id) ON DELETE CASCADE
     ,client_id INTEGER NOT NULL
     ,FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE
);
-- rollback drop table travel_order_attendances