# pyg_test

docker pull postgres 

docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=1234 -d postgres 

docker exec -it postgres /bin/bash

postgresql 접속
=> psql -U postgres

postgresql 슈퍼 유저 생성 (CREATE ROLE)
CREATE USER pyg PASSWORD '1234' SUPERUSER;

postgresql 데이터베이스 생성 (CREATE DATABASE)
create database test owner pyg;

postgresql 테이블 생성
CREATE TABLE members(
   ID  SERIAL ,
   userId varchar(50) , 
   username varchar(50) NOT NULL, 
   passsword varchar(100)  NOT NULL,
   created_date     timestamp 
);

ALTER TABLE ONLY  members ADD CONSTRAINT "ID_PKEY" PRIMARY KEY (ID,userId);

ALTER TABLE public.members RENAME COLUMN passsword TO "password";

ALTER TABLE public.members ADD "role" varchar(5) NULL;


select * from members

update members set role = 'ADMIN' where 1=1


insert into members(userid,username, password, created_date)
values ('pyg','pyg','1234', now())


insert into members(userid,username, password, created_date)
values ('admin','pyg','1234', now())
