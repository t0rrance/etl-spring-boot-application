--liquibase formatted sql

-- changeset mk:create-accommodations
 create table accommodations
(
    id integer primary key not null auto_increment
    ,id_accommodation integer not null
    ,type_accommodation varchar (200)
    ,address varchar (200)
    ,price_per_day integer
    ,timestampFrom timestamp NULL DEFAULT NULL
    ,timestampTo   timestamp NULL DEFAULT NULL
);
-- rollback drop table accommodations

-- changeset mk:create-travels
create table travels
(
    id integer primary key not null auto_increment
    ,id_travel integer not null
    ,travel_name varchar (200)
    ,number_of_seats integer
    ,number_occupied_seats integer
    ,price_per_seat integer
    ,start_date date
    ,finish_date date
    ,timestampFrom timestamp NULL DEFAULT NULL
    ,timestampTo   timestamp NULL DEFAULT NULL
);
-- rollback drop table travels

-- changeset mk:create-clients
create table clients
(
    id integer primary key not null auto_increment
    ,id_client integer not null
    ,first_name varchar (200)
    ,last_name varchar (200)
    ,phone_number integer
    ,address  varchar (400)
    ,timestampFrom timestamp NULL DEFAULT NULL
    ,timestampTo   timestamp NULL DEFAULT NULL
);
-- rollback drop table clients

-- changeset mk:create-additional_items
create table additional_items
 (
     id integer primary key not null auto_increment
     ,id_additional_item integer not null
     ,item_name varchar (200) not null
     ,price_per_seat integer
     ,timestampFrom timestamp NULL DEFAULT NULL
     ,timestampTo   timestamp NULL DEFAULT NULL
 );
-- rollback drop table additional_items

-- changeset mk:create-travel-orders
create table travel_orders
(
    id integer primary key not null auto_increment
    ,id_travel_order integer not null
    ,travel_id integer not null
    ,client_id integer not null
    ,number_of_seats integer
    ,order_date date
    ,payment_date date
    ,timestampFrom timestamp NULL DEFAULT NULL
    ,timestampTo   timestamp NULL DEFAULT NULL
);
-- rollback drop table travel_orders

-- changeset mk:create-travel_order_attendances
create table travel_order_attendances
(
     id integer primary key not null auto_increment
     ,id_travel_order_attendance integer not null
     ,travel_order_id INTEGER NOT NULL
     ,client_id INTEGER NOT NULL
     ,timestampFrom timestamp NULL DEFAULT NULL
     ,timestampTo   timestamp NULL DEFAULT NULL
);
-- rollback drop table travel_order_attendances

-- changeset mk:create-travel_additional_items
create table travel_additional_items
(
     id integer primary key not null auto_increment
     ,id_travel_additional_item integer not null
     ,travel_id INTEGER NOT NULL
     ,additional_item_id INTEGER NOT NULL
     ,timestampFrom timestamp NULL DEFAULT NULL
     ,timestampTo   timestamp NULL DEFAULT NULL
);
-- rollback drop table travel_additional_items

-- changeset mk:create-travel_accommodations
create table travel_accommodations
(
      id integer primary key not null auto_increment
      ,id_travel_accommodation integer not null
      ,travel_id INTEGER NOT NULL
      ,accommodation_id INTEGER NOT NULL
      ,timestampFrom timestamp NULL DEFAULT NULL
      ,timestampTo   timestamp NULL DEFAULT NULL
);
-- rollback drop table travel_accommodations