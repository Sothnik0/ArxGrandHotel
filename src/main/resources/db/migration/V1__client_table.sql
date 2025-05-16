CREATE TYPE role_enum AS ENUM ('ROLE_USER', 'ROLE_ADMIN');

CREATE TABLE Client (
    id UUID PRIMARY KEY NOT NULL,

    login VARCHAR(50) NOT NULL UNIQUE,
    password TEXT NOT NULL,

    name VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL UNIQUE,
    gender VARCHAR(10) NOT NULL CHECK (gender IN ('MASCULINO', 'FEMININO', 'OUTRO')),

    role role_enum NOT NULL DEFAULT 'ROLE_USER',

    arrival DATE NOT NULL,
    nightAmount NUMERIC(3,0) NOT NULL CHECK (nightAmount > 0),
    clientAmount NUMERIC(3,0) NOT NULL CHECK (clientAmount > 0),

    message VARCHAR(260) NOT NULL
);
