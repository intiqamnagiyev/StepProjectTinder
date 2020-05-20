create table liked
(
	id serial not null
		constraint liked_pk
			primary key,
	who_id integer not null
		constraint liked___fk_who
			references users,
	whom_id integer not null
		constraint liked___fk_whom
			references users,
	date timestamp default now(),
	status boolean default true
);


