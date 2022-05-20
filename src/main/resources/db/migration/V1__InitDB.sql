BEGIN;

CREATE TABLE player
(
    id                      UUID         NOT NULL PRIMARY KEY,
    firstName               VARCHAR(100) NOT NULL,
    lastName                VARCHAR(100) NOT NULL,
    dateCreated             TIMESTAMPTZ  NOT NULL
);

COMMIT;
