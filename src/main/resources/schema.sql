create table Planted
(
id integer not null AUTO_INCREMENT,
farm_id varchar(255) not null,
farmer_first_name varchar(255) not null,
farmer_last_name varchar(255) not null,
area integer not null,
corp_type varchar(255) not null,
expected_quantity integer not null,
season varchar(255) not null,
primary key(id)
);

create table Harvested
(
id integer not null AUTO_INCREMENT,
planted_id int not null,
farm_id varchar(255) not null,
actual_quantity integer not null,
primary key(id),
FOREIGN KEY (planted_id) REFERENCES Planted(id)
);


insert into PLANTED (farm_id,farmer_first_name,farmer_last_name,area,corp_type,expected_quantity,season) values ('f001','F1','L1',2,'corn',10,'2024') ;

insert into PLANTED (farm_id,farmer_first_name,farmer_last_name,area,corp_type,expected_quantity,season) values ('f001','F1','L1',2,'potato',20,'2024') ;

insert into harvested (planted_id,farm_id,actual_quantity)values (01,'f001',15);

insert into harvested (planted_id,farm_id,actual_quantity)values (02,'f001',25);


insert into PLANTED (farm_id,farmer_first_name,farmer_last_name,area,corp_type,expected_quantity,season) values ('f002','F2','L2',2,'corn',10,'2024') ;

insert into PLANTED (farm_id,farmer_first_name,farmer_last_name,area,corp_type,expected_quantity,season) values ('f002','F2','L2',2,'potato',20,'2024') ;

insert into harvested (planted_id,farm_id,actual_quantity)values (03,'f002',25);

insert into harvested (planted_id,farm_id,actual_quantity)values (04,'f002',55);
