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



--Get Library
select * from books;

--Select Via Title
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

--Delete via book ID
delete from books where book_id = 27;

--Add column to DB
ALTER TABLE books
ADD description varchar(4000); 

ALTER TABLE books
ADD genres varchar (3500);

ALTER TABLE books
ADD published_date varchar(30);

ALTER TABLE books
ADD google_average_rating int;

ALTER TABLE books
ADD google_number_of_ratings int;

ALTER TABLE books
ADD google_average_rating int;


--SELECT BOOKS BY genre 
select book_id, title, genre
from books
where genre != 'Non-Fiction' AND genre != 'Fiction'
ORDER BY book_id DESC

--Update GENRE
UPDATE books 
SET genre = 'Fiction'
where genre != 'Non-Fiction' AND genre != 'Fiction'

-- SUM 


--COUNT 
SELECT *
FROM books 
WHERE cover_price < 100

WHERE (price > 0) AND (price < 100)

--Get Most Expensive Book
SELECT * 
From books
where price = (SELECT MAX(price) FROM books)

--Get MIN
SELECT * 
From books
where price = (SELECT MIN(price) FROM books WHERE price > 0)

update books set format = 'Paperback' where format = 'Softcover'
select title, book_id, price, cover_price from books where book_id = 40
select title, book_id, price, cover_price from books where book_id = 2