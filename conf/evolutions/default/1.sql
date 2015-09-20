# Users schema

# --- !Ups
CREATE TABLE `users` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `p_id` BIGINT(20),
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `first_name` VARCHAR(255) NOT NULL,
    `nickname` VARCHAR(255),
    `last_name` VARCHAR(255),
    `lat` DECIMAL(11, 8) DEFAULT 0,
    `lng` DECIMAL(10, 8) DEFAULT 0,
    `city` VARCHAR(255) NOT NULL,
    `country` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255),
    `admin_type` ENUM('1','2','3','4','5') DEFAULT 1,
    `status` tinyINT DEFAULT 1,
    `mobile_number` INT(15),
    `country_code` INT(5),
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `full_mobile_number` (`mobile_number`, `country_code`),
    INDEX `email` (`email`),
    UNIQUE KEY `country_mobile_number` (`mobile_number`,`country_code`)
);

# --- !Downs
DROP TABLE users;
