CREATE TABLE product
(
    product_id   BINARY(16) PRIMARY KEY,
    product_name VARCHAR(20) NOT NULL,
    category     VARCHAR(50) NOT NULL,
    price        BIGINT      NOT NULL,
    description  VARCHAR(500) DEFAULT NULL,
    created_at   datetime(6) NOT NULL,
    updated_at   datetime(6)  DEFAULT NULL
)
