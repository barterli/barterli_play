CREATE TABLE users (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    first_name varchar(255) NOT NULL,
    nickname varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    lat_long varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    country varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    admin_type ENUM(1,2,3,4,5) DEFAULT 1,
    mobile_number int(11),
    country_code int(5),
    PRIMARY KEY (id),
    INDEX phone_no (mobile_number, country_code),
    INDEX email
);

CREATE TABLE authentications (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    user_id bigint(20),
    uid bigint(20),
    provider varchar(255) NOT NULL,
    token varchar(255) NOT NULL,
    token_secret varchar(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users(id),
    INDEX user_id,
    INDEX uid
);