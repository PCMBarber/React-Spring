
DROP TABLE `seller` CASCADE CONSTRAINTS;

CREATE TABLE `seller` (
    `seller_id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `first` VARCHAR,
    `last` VARCHAR
);