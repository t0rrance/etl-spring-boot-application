--liquibase formatted sql

-- changeset mk:insert-travels
insert into travels values (1, 't4', 9999,0,1000, '2020-01-01',  '2020-01-01');
insert into travels values (2, 't5', 9999,0,1000, '2020-01-01',  '2020-01-01');
insert into travels values (3, 't6', 9999,0,1000, '2020-01-01',  '2020-01-01');
-- rollback delete table travels

-- changeset mk:insert-additional_items
insert into additional_items values (1, 'item1', 500);
insert into additional_items values (2, 'item1', 600);
insert into additional_items values (3, 'item1', 700);
-- rollback delete table additional_items

-- changeset mk:insert-clients
insert into clients values (1, 'first4','lastName', 123456789 , 'street 01');
insert into clients values (2, 'first5','lastName', 123456789 , 'street 02');
insert into clients values (3, 'first6','lastName', 123456789 , 'street 03');
-- rollback delete table clients

-- changeset mk:insert-travel_orders
insert into travel_orders values (1, 1, 1, 50, '2020-01-01', '2019-01-01');
insert into travel_orders values (2, 2, 1, 50, '2019-01-01', '2019-01-01');
insert into travel_orders values (3, 3, 1, 50, '2019-01-01', '2019-01-01');
-- rollback delete table travel_orders

-- changeset mk:insert-travel_additional_items
insert into travel_additional_items values (1,1,1);
insert into travel_additional_items values (2,2,2);
insert into travel_additional_items values (3,3,3);
-- rollback delete table travel_additional_items

-- changeset mk:insert-travel_order_attendances
insert into travel_order_attendances values (1,1,2);
insert into travel_order_attendances values (2,2,2);
insert into travel_order_attendances values (3,3,2);
-- rollback delete table travel_order_attendances



