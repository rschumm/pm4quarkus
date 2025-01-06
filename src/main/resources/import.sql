-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into Proposal (id, title, subtitle, author) values 
(1, 'Herbal Garden Cat Protector', 'In this project we want to build an animal friendly protection system, that chases cats from the garden with a water gun', 'Engeli'), 
(2, 'Personal Time-Assistant für ADHS Betroffene', 'Leute mit ADHS haben oft Probleme, an all die Kleinen Dinge zu denken, die es im Alltag zu tun gibt', 'Langhard-Renold');
 