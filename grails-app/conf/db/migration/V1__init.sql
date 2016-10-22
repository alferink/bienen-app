create sequence hibernate_sequence start 1 increment 1;
create table aktion (id int8 not null, version int8 not null, datum timestamp not null, class varchar(255) not null, anzahl int4, anzahl_kontrolltage int4, ausgebaute_waben int4, bemerkung varchar(4000), brut int4, brutwaben int4, drohnenbrut_geschnitten boolean, futterwaben int4, koenigin_gesehen boolean, mittelwaende int4, sanftmut int4, volksstaerke int4, wabensitz int4, chargen_nummer varchar(255), menge numeric(19, 2), methode varchar(255), mittel varchar(255), art varchar(255), sorte varchar(255), wassergehalt numeric(19, 2), primary key (id));
create table bienenstand (id int8 not null, version int8 not null, name varchar(255) not null, standort varchar(255) not null, x numeric(19, 2) not null, y numeric(19, 2) not null, primary key (id));
create table bienenstand_bienenvolk (bienenstand_voelker_id int8 not null, bienenvolk_id int8);
create table bienenvolk (id int8 not null, version int8 not null, erstellt timestamp not null, koenigin_id int8 not null, name varchar(255) not null, primary key (id));
create table koenigin (id int8 not null, version int8 not null, geburtsjahr int4 not null, primary key (id));
create table sec_role (id int8 not null, version int8 not null, authority varchar(255) not null, primary key (id));
create table sec_user (id int8 not null, version int8 not null, account_expired boolean not null, account_locked boolean not null, enabled boolean not null, "password" varchar(255) not null, password_expired boolean not null, username varchar(255) not null, primary key (id));
create table sec_userrole (user_id int8 not null, role_id int8 not null, primary key (user_id, role_id));
alter table sec_role add constraint UK_oah023x2ltqw09mdue7w0mcxb unique (authority);
alter table sec_user add constraint UK_5ctbdrlf3eismye20vsdtk8w8 unique (username);
alter table bienenstand_bienenvolk add constraint FK18ns9v5weeh0n6rimoi4fwtum foreign key (bienenvolk_id) references bienenvolk;
alter table bienenstand_bienenvolk add constraint FKf8vxsrb9f9w7kx0lju5e7winh foreign key (bienenstand_voelker_id) references bienenstand;
alter table bienenvolk add constraint FKm7jley1hwaosb8q05r4xj4pse foreign key (koenigin_id) references koenigin;
alter table sec_userrole add constraint FKg1dcqd7a0imwfbbt73ad2iqna foreign key (user_id) references sec_user;
alter table sec_userrole add constraint FKo0did7mtfullggl6ujfuufc3p foreign key (role_id) references sec_role;
