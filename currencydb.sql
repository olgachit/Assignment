DROP DATABASE IF EXISTS currencydb;

CREATE DATABASE currencydb;
USE currencydb;

DROP TABLE IF EXISTS Currency;

CREATE TABLE Currency (
    abbreviation CHAR(3) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    rate_to_usd DECIMAL(15,6) NOT NULL
);

INSERT INTO Currency (abbreviation, name, rate_to_usd) VALUES
    ('USD', 'US Dollar', 1.000000),
    ('EUR', 'Euro', 0.930000),
    ('GBP', 'British Pound', 0.820000),
    ('JPY', 'Japanese Yen', 138.000000),

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON company.* TO 'appuser'@'localhost';

FLUSH PRIVILEGES;
