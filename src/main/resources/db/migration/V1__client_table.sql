CREATE TABLE Client (
    id UUID PRIMARY KEY NOT NULL,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    name VARCHAR(60) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    role VARCHAR(10) NOT NULL,
    arrival DATE NOT NULL,
    nightAmount NUMERIC NOT NULL,
    clientAmount NUMERIC NOT NULL,
    message VARCHAR(260) NOT NULL
);