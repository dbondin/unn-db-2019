CREATE TABLE public.animal (
    dtype character varying(31) NOT NULL,
    id bigint NOT NULL,
    descr character varying(255),
    name character varying(255),
    color character varying(255)
);

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
CREATE TABLE public.x (
    id integer NOT NULL,
    value1 character varying(255) NOT NULL,
    value2 integer
);

CREATE TABLE public.x_author (
    auth_id bigint NOT NULL,
    auth_first_name character varying(64) NOT NULL,
    auth_last_name character varying(64) NOT NULL
);

CREATE TABLE public.x_book (
    book_id bigint NOT NULL,
    book_title character varying(256) NOT NULL,
    book_lang_id bigint NOT NULL
);

CREATE TABLE public.x_book_author (
    book_id bigint NOT NULL,
    author_id bigint NOT NULL
);

CREATE TABLE public.x_lang (
    lang_id bigint NOT NULL,
    lang_descr character varying(255),
    lang_name character varying(255) NOT NULL
);

ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.x_lang
    ADD CONSTRAINT uk_sg9pi35q3xrti9kcvuu5tv2w0 UNIQUE (lang_name);

ALTER TABLE ONLY public.x_author
    ADD CONSTRAINT x_author_pkey PRIMARY KEY (auth_id);

ALTER TABLE ONLY public.x_book_author
    ADD CONSTRAINT x_book_author_pkey PRIMARY KEY (book_id, author_id);

ALTER TABLE ONLY public.x_book
    ADD CONSTRAINT x_book_pkey PRIMARY KEY (book_id);

ALTER TABLE ONLY public.x_lang
    ADD CONSTRAINT x_lang_pkey PRIMARY KEY (lang_id);

ALTER TABLE ONLY public.x
    ADD CONSTRAINT x_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.x_book
    ADD CONSTRAINT fk1q0o7v0xf85ikpiorek0534l2 FOREIGN KEY (book_lang_id) REFERENCES public.x_lang(lang_id);

ALTER TABLE ONLY public.x_book_author
    ADD CONSTRAINT fk2sbotu7r3u5n72k05u6osguxc FOREIGN KEY (author_id) REFERENCES public.x_author(auth_id);

ALTER TABLE ONLY public.x_book_author
    ADD CONSTRAINT fkngca8lcugsf3adu6b8bkd20gn FOREIGN KEY (book_id) REFERENCES public.x_book(book_id);
