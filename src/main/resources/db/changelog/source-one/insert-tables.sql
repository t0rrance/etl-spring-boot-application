--liquibase formatted sql

-- changeset mk:insert-accommodations
insert into accommodations values (1, 'h1', 'street1' , 1000);
insert into accommodations values (2, 'h2', 'street2' , 2000);
insert into accommodations values (3, 'h3', 'street3' , 3000);
-- rollback delete table accommodations

-- changeset mk:insert-travels
insert into travels values (1, 't1', 10,0,1000, '2019-01-01',  '2019-01-01');
insert into travels values (2, 't1', 10,0,1000, '2019-01-01',  '2019-01-01');
insert into travels values (3, 't1', 10,0,1000, '2019-01-01',  '2019-01-01');
-- rollback delete table travels

-- changeset mk:insert-clients
insert into clients values (1, 'first1','lastName', 123456789 , 'street 01');
insert into clients values (2, 'first2','lastName', 123456789 , 'street 02');
insert into clients values (3, 'first3','lastName', 123456789 , 'street 03');
-- rollback delete table clients

-- changeset mk:insert-travel_accommodations
insert into travel_accommodations values (1,1,1);
insert into travel_accommodations values (2,2, 1);
insert into travel_accommodations values (3,3, 1);
-- rollback delete table travel_accommodations

-- changeset mk:insert-travel_orders
insert into travel_orders values (1, 1, 1, 5, '2019-01-01', '2019-01-01');
insert into travel_orders values (2, 2, 1, 5, '2019-01-01', '2019-01-01');
insert into travel_orders values (3, 3, 1, 5, '2019-01-01', '2019-01-01');
-- rollback delete table travel_orders

