CREATE TABLE cart
(
    id     INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    status SMALLINT                                 NOT NULL,
    CONSTRAINT pk_cart PRIMARY KEY (id)
);