CREATE TABLE Client (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(60) NOT NULL,
    gender VARCHAR(30) NOT NULL,
    arrival DATE NOT NULL,
    nightAmount NUMERIC NOT NULL,
    clientAmount NUMERIC NOT NULL,
    message VARCHAR(260) NOT NULL
);

