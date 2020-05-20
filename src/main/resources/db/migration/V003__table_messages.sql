create table messages
(
	id serial not null
		constraint messages_pk
			primary key,
	from_user integer not null
		constraint messages___fk_from
			references users,
	to_user integer not null
		constraint messages___fk_to
			references users,
	content varchar(1000000),
	status boolean default true,
	insert_date timestamp default now()
);



