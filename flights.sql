-- 1. Ceate users table
-- Store user information

CREATE TABLE flight_users (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25;


insert into flight_users values (1,'test1@gmail.com','test1');
insert into flight_users values (2,'test2@gmail.com','test2');
insert into flight_users values (3,'test3@gmail.com','test3');


select * from users;


CREATE TABLE cities (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25;

insert into cities values(1,'New York');
insert into cities values(2,'San Francisco');
insert into cities values(3,'Boston');
insert into cities values(4,'Tampa');
insert into cities values(5,'Chicago');
insert into cities values(6,'Atlanta');
insert into cities values(7,'Houston');
insert into cities values(8,'Orlando');
insert into cities values(9,'Austin');
insert into cities values(10,'Nashville');

select * from cities;


create table flights(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
  `airline` varchar(50) NOT NULL,
  `from_city` varchar(50) NOT NULL,
  `to_city` varchar(50) NOT NULL,
   price double(16,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25;


insert into flights values (1,'Delta', 'New York', 'Atlanta',200);
insert into flights values (2,'Delta', 'San Francisco', 'Atlanta',400);
insert into flights values (3,'Delta', 'Boston', 'Atlanta',300);
insert into flights values (4,'Delta', 'Boston', 'Atlanta',250);
insert into flights values (5,'AA', 'San Francicso', 'Atlanta',450);
insert into flights values (6,'AA', 'San Francicso', 'Houston',150);
insert into flights values (7,'AA', 'San Francicso', 'Orlando',650);
insert into flights values (8,'AA', 'San Francicso', 'Austin',50);
insert into flights values (9,'AA', 'San Francicso', 'Nashville',500);
insert into flights values (10,'AA', 'San Francicso', 'Tampa',300);
insert into flights values (11,'United', 'Chicago', 'Tampa',200);
insert into flights values (12,'United', 'Chicago', 'Orlando',250);
insert into flights values (13,'United', 'Chicago', 'Austin',150);
insert into flights values (14,'United', 'Chicago', 'New York',320);
insert into flights values (15,'United', 'Chicago', 'Nashville',30);


select * from flights;


-- Bookings made by user

CREATE TABLE bookings(
		id bigint(20) NOT NULL auto_increment,
		airline varchar(50) NOT NULL,
        num_passengers integer(20) not null,
        dep_date date not null,
		arrival_time varchar(40) not null,
		user_id bigint(20) not null,
		total_cost double(16,2) NOT NULL,
	PRIMARY KEY (id),
    foreign key(user_id) references flight_users(id) on delete cascade on update cascade
)ENGINE=InnoDB AUTO_INCREMENT=25;

insert into bookings values(1,'Delta',2,'2018-12-23', '09:30 Hrs',1,250);
insert into bookings values(2,'AA',1,'2019-01-03', '12:30 Hrs',2,1250);
insert into bookings values(3,'United',1,'2019-10-30', '19:30 Hrs',3,2500);


select * from bookings;





