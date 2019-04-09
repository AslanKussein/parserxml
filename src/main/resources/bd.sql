create database test;
create schema docs;

create table docs.t_document_root
(
    id           varchar(222) primary key,
    redaction_id varchar(222),
    doctype_id   varchar(222)

);