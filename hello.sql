create database HelloWorld;
GRANT ALL PRIVILEGES ON HelloWorld.* TO 'HelloWorld'@'%' IDENTIFIED BY 'INT206@HelloWorld';
FLUSH PRIVILEGES;

create table HelloWorld.hello(
	id int,
    message varchar(150),
    primary key (id)
);