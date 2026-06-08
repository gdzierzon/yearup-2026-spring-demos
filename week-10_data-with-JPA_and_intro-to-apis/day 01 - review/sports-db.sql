USE sys;

DROP DATABASE IF EXISTS sports;

CREATE DATABASE IF NOT EXISTS sports;

USE sports;

CREATE TABLE athletes
(
    athlete_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    event VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    PRIMARY KEY (athlete_id)
);

-- insert records
INSERT INTO athletes(athlete_id, first_name, last_name, event, country)
VALUES (1, 'Sophia','Davis','Pole Vault','CAN')
    , (2, 'Ethan','Johnson','100 m','USA')
    , (3, 'Liam','Anderson','100 m','USA')
    , (4, 'Noah','Thompson','Pole Vault','CAN')
    , (5, 'Ava','Davis','100 m','CAN')
    , (6, 'Isabella','Johnson','Hurdles','USA');