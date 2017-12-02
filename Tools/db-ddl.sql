drop table CUSTOMER cascade constraints
create table CUSTOMER (CUSTOMER_ID number(10,0) not null, FIRSTNAME varchar2(50 char) not null, LASTNAME varchar2(50 char), MOBILE varchar2(13 char) not null, EMAIL varchar2(100 char) not null, primary key (CUSTOMER_ID))
alter table CUSTOMER add constraint UK_rlhhgj4x81jlr1c4rw9f4s3s5  unique (MOBILE)
alter table CUSTOMER add constraint UK_mk3cgvpjoy0vr5tbjwp5g13i1  unique (EMAIL)
