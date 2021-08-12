create sequence authors_id_seq start 1 increment 1;
create sequence books_id_seq start 1 increment 1;

drop table if exists authors_books;
drop table if exists authors;
drop table if exists books;



create table authors
(
    author_id            int8 not null,
    first_name           varchar(255),
    second_name         varchar(255),
    last_name            varchar(255),
    birth_date          date,
    primary key (author_id)
);

create table books
(
    book_id           int8 not null,
    isbn      varchar(255) not null,
    page_count   int not null,
    publish_date date not null,
    title        varchar(255) not null,
    title_original   varchar(255) not null,
    primary key (book_id)
);

create table authors_books
(
    book_id           int8 REFERENCES books (book_id) ON UPDATE CASCADE ON DELETE CASCADE,
    author_id         int8    REFERENCES authors (author_id) ON UPDATE CASCADE,
    CONSTRAINT authors_books_pkey PRIMARY KEY (book_id, author_id)

);

ALTER TABLE authors
    ALTER COLUMN author_id
        SET DEFAULT nextval('authors_id_seq');

ALTER TABLE books
    ALTER COLUMN book_id
        SET DEFAULT nextval('books_id_seq');
