create table if not exists user (
 id int not null primary key auto_increment,
name varchar(100) default 'nullname',
sex varchar(1) default '1',
age NUMBER(3) default '18');