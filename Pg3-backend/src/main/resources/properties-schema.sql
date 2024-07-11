DROP TABLE `properties`;

CREATE TABLE `properties` (
    `property_id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `type` VARCHAR,
    `location` VARCHAR,
    `bedrooms` INTEGER,
    `bathrooms` INTEGER,
    `price` INTEGER,
    `image_url` VARCHAR,
    `seller_seller_id` INTEGER
);