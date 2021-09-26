DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    title     VARCHAR(20),
    firstname VARCHAR(250),
    surname   VARCHAR(250),
    dob       DATE,
    created   TIMESTAMP
)