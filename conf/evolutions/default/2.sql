# Authentications schema

# --- !Ups
CREATE TABLE authentications (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT(20),
    `uid` BIGINT(20),
    `provider` VARCHAR(255) NOT NULL,
    `token` VARCHAR(255) NOT NULL,
    `token_secret` VARCHAR(255) NOT NULL,
    `created_at` TIMESTAMP,
    `updated_at` TIMESTAMP,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_users` FOREIGN KEY (`user_id`) REFERENCES users(`id`),
    INDEX `user_id`(user_id),
    INDEX `uid`(`uid`)
);


# --- !Downs
DROP TABLE authentications;