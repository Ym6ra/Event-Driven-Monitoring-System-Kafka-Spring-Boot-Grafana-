-- Active: 1781459246077@@127.0.0.1@5432@testdb
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customerId: INT,
    product VARCHAR(255),
    quantity INT
);