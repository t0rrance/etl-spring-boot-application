--liquibase formatted sql

-- changeset mk:create-accommodations
create table accommodations
(
    id integer primary key not null auto_increment
    ,type_accommodation varchar (200)
    ,address varchar (200)
    ,price_per_day integer
);
-- rollback drop table accommodations

-- chaneset mk:create-travels
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

-- changeset mk:create-travel_accommodations
create table travel_accommodations
(
     id integer primary key not null auto_increment
     ,travel_id INTEGER NOT NULL
     ,FOREIGN KEY (travel_id) REFERENCES travels(id) ON DELETE CASCADE
     ,accommodation_id INTEGER NOT NULL
     ,FOREIGN KEY (accommodation_id) REFERENCES accommodations(id) ON DELETE CASCADE
);
-- rollback drop table travel_accommodations

-- changeset mk: create-travel_orders
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
)
-- rollback drop table travel_orders

