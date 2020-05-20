create table users
(
	id serial not null
		constraint users_pk
			primary key,
	name varchar not null,
	surname varchar not null,
	job varchar,
	last_login timestamp default now(),
	password varchar not null,
	status boolean default true,
	email varchar not null,
	photo varchar
);



