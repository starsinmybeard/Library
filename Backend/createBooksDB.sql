DROP table if exists books;


CREATE TABLE books(
	book_id serial,
	title varchar(100),
	author varchar(100),
	genre varchar(100),
	condition varchar(100),
	price int,
	format varchar(100),
	purchase_location varchar(100),
	purchase_date varchar(30),
	notes varchar(500),
	isbn varchar(20),
	read_status boolean
);

CREATE TABLE movies(
	movie_id serial,
	title varchar(50),
	director varchar(50),
	genre varchar(50),
	condition varchar(50),
	price int,
	format varchar(10),
	purchase_location varchar(100),
	purchase_date varchar(30),
	notes varchar(500),
	isbn varchar(20),
	rating int,
	watch_status boolean
);



INSERT INTO books(title, author, genre, isbn, condition, price, format, purchase_location, purchase_date, notes, read_status)
VALUES ('Beartown', 'Frederik Backman', 'fiction', 1501160761, 'Great', 3, 'Softcover', 'Garland County Library', 'July 4', 'Love this book.', TRUE);




select * from books;

select title, author, genre, condition, price, purchase_location, notes
 FROM books
 Where title = 'Beartown';
 
 
--  Change ISBN 
UPDATE books 
SET isbn = ''
WHERE book_id = ;

--Change Purchase Location
UPDATE books 
SET purchase_location = ''
WHERE book_id = ;

delete from books where book_id = 27