create table public.p_personel(
	id bigint not null,
	first_name varchar(255),
	last_name varchar(255),
	
);

create table public.p_pet(
	id bigint not null,
	first_name varchar(255),
	birth_date date,
	personel_id bigint
);

alter table public.p_personel add constraint public.constraint_1 primary key(id);

alter table public.p_pet add constraint public.constraint_2 primary key(id);

alter table public.p_pet add constraint public.constraint_3 foreign key(personel_id) references public.p_personel(id);

create sequence public.petclinic_sequence start with 100;

