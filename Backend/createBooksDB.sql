DROP table if exists books;


CREATE TABLE books(
	book_id serial,
	title varchar(50),
	author varchar(50),
	genre varchar(50),
	condition varchar(50),
	price int,
	purchase_location varchar(100),
	purchase_date varchar(30),
	notes varchar(500),
	isbn varchar(20),
	read_status boolean
);

select * from books;

INSERT INTO books(title, author, genre, isbn, condition, price, purchase_location, purchase_date, notes, read_status)
VALUES ('Beartown', 'Frederik Backman', 'fiction', 1501160761, 'Great', 3, 'Garland County Library', 'July 4', 'Love this book.', TRUE);

select title, author, genre, condition, price, purchase_location, notes
 FROM books
 Where title = 'Beartown';