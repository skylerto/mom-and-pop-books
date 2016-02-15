CREATE DATABASE ecommerce;
USE ecommerce;

CREATE USER bookstore_user IDENTIFIED BY '4413';
GRANT ALL PRIVILEGES ON ecommerce.* TO bookstore_user;

DROP TABLE IF EXISTS book;
CREATE TABLE book (
                   bid varchar(20) NOT NULL,
                   title varchar(60) NOT NULL,
                   price INT NOT NULL,
                   category enum('Science','Fiction','Engineering') NOT NULL,
                   PRIMARY key(bid));

INSERT INTO book (bid, title, price, category)
VALUES ('b001',
        'Little Prince',
        20,
        'Fiction');

INSERT INTO book (bid, title, price, category)
VALUES ('b002',
        'Physics',
        201,
        'Science');

INSERT INTO book (bid, title, price, category)
VALUES ('b003',
        'Mechanics',
        100,
        'Engineering');


DROP TABLE IF EXISTS address;
CREATE TABLE address (
											id INT UNSIGNED NOT NULL auto_increment,
											street varchar(100) NOT NULL,
											province varchar(20) NOT NULL,
											country varchar(20) NOT NULL,
											zip varchar(20) NOT NULL,
											phone varchar(20),
											PRIMARY key(id));


INSERT INTO address (id, street, province, country, zip, phone)
VALUES (1,
        '123 Yonge St',
        'ON',
        'Canada',
        'K1E 6T5',
        '647-123-4567');


INSERT INTO address (id, street, province, country, zip, phone)
VALUES (2,
        '445 Avenue rd',
        'ON',
        'Canada',
        'M1C 6K5',
        '416-123-8569');


INSERT INTO address (id, street, province, country, zip, phone)
VALUES (3,
        '789 Keele St.',
        'ON',
        'Canada',
        'K3C 9T5',
        '416-123-9568');


DROP TABLE IF EXISTS po;
CREATE TABLE po (
                 id INT UNSIGNED NOT NULL auto_increment,
                 lname varchar(20) NOT NULL,
                 fname varchar(20) NOT NULL,
                 status enum('ORDERED','PROCESSED','DENIED') NOT NULL,
                 address INT UNSIGNED NOT NULL,
                 PRIMARY key(id), INDEX (address),
                 FOREIGN KEY (address) REFERENCES address (id) ON
                 DELETE cascade);

INSERT INTO po (id, lname, fname, status, address)
VALUES (1,
        'John',
        'White',
        'PROCESSED',
        '1');


INSERT INTO po (id, lname, fname, status, address)
VALUES (2,
        'Peter',
        'Black',
        'DENIED',
        '2');


INSERT INTO po (id, lname, fname, status, address)
VALUES (3,
        'Andy',
        'Green',
        'ORDERED',
        '3');


DROP TABLE IF EXISTS poitem;
CREATE TABLE poitem (id INT UNSIGNED NOT NULL,
                     bid varchar(20) NOT NULL,
                     price INT UNSIGNED NOT NULL,
                     PRIMARY KEY(id,bid),
                     INDEX (id),
                     FOREIGN KEY(id) REFERENCES po(id) ON
                     DELETE CASCADE, INDEX (bid),
                     FOREIGN KEY(bid) REFERENCES book(bid) ON
                     DELETE CASCADE);


INSERT INTO poitem (id, bid, price)
VALUES (1,
        'b001',
        '20');


INSERT INTO poitem (id, bid, price)
VALUES (2,
        'b002',
        '201');


INSERT INTO poitem (id, bid, price)
VALUES (3,
        'b003',
        '100');


CREATE TABLE visitevent (DAY varchar(8) NOT NULL,
                         bid varchar(20) NOT NULL REFERENCES book.bid,
                         eventtype enum('VIEW','CART','PURCHASE') NOT NULL,
                         FOREIGN KEY(bid) REFERENCES book(bid));


INSERT INTO visitevent (DAY, bid, eventtype)
VALUES ('12202015',
        'b001',
        'VIEW');


INSERT INTO visitevent (DAY, bid, eventtype)
VALUES ('12242015',
        'b001',
        'CART');


INSERT INTO visitevent (DAY, bid, eventtype)
VALUES ('12252015',
        'b001',
        'PURCHASE');