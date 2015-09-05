CREATE TABLE users (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    lat_long varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    country varchar(255) NOT NULL,
    admin_type int(1),
    mobile_number int(11),
    PRIMARY KEY (id)
);