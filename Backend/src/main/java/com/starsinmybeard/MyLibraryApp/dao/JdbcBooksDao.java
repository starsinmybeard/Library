package com.starsinmybeard.MyLibraryApp.dao;
import com.starsinmybeard.MyLibraryApp.models.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBooksDao implements BookDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcBooksDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    //AddsBook
    @Override
    public void addBook(Book book){
        String sql =
                " insert into books(title, subtitle, author, genre, isbn, condition, price, cover_price, " +
                        " format, pages, purchase_location, purchase_date, read_status, notes) " +
                        " Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        Boolean readStatusBoolean;
        jdbcTemplate.update(sql, book.getBookTitle(), book.getSubtitle(), book.getAuthor(),
                book.getGenre(), book.getIsbn(),
                book.getCondition(), book.getPrice(), book.getCoverPrice(),
                book.getFormat(), book.getPages(), book.getPurchaseLocation(), book.getPurchaseDate(),
                Boolean.parseBoolean(book.getReadStatus()), book.getNotes());
    };

    //Returns List of All Books
    @Override
    public List<Book> getAllBooks() {
        List<Book> results = new ArrayList<>();

        String sql = " SELECT  book_id, title, subtitle, author, genre, isbn, condition, price, cover_price, " +
                " format, pages, purchase_location, purchase_date, notes, read_status " +
                " from books; ";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        while (rowSet.next()){
            Book book = mapRowToBook(rowSet);
            results.add(book);
        }

        return results;
    }


    //Returns Book by title
    @Override
    public Book getBook(int bookId) {
        Book result = new Book();
        String sql =
                " SELECT book_id, title, subtitle, author, genre, isbn, condition, price, cover_price, format, pages, purchase_location, purchase_date, notes, read_status " +
                " FROM books " +
                " WHERE book_id = ?; ";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, bookId);

        while(rowSet.next()){
            Book book = mapRowToBook(rowSet);
            result = book;
        }
        return result;
    }


     //Returns List of Books bought at CG Library
    @Override
    public List<Book> boughtFromGarlandCounty() {
        List<Book> results = new ArrayList<>();
        String sql = " SELECT  book_id, title, subtitle, author, genre, isbn, condition, price, cover_price, format, pages, purchase_location, purchase_date, notes, read_status " +
                " from books " +
                " where purchase_location = 'Garland County Library Bookstore'; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Book book = mapRowToBook(rowSet);
            results.add(book);
        }
        return results;
    }

    @Override
    public List<Book> boughtFromEbay() {
        List<Book> results = new ArrayList<>();
        String sql = " SELECT  book_id, title, subtitle, author, genre, isbn, condition, price, cover_price, format, " +
                " pages, purchase_location, purchase_date, notes, read_status " +
                " from books " +
                " where purchase_location = 'Ebay'; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Book book = mapRowToBook(rowSet);
            results.add(book);}
        return results;
    }

    @Override
    public List<Book> boughtFromAmazon() {
        List<Book> results = new ArrayList<>();
        String sql = " SELECT  book_id, title, subtitle, author, genre, isbn, condition, price, cover_price, format, pages, purchase_location, purchase_date, notes, read_status " +
                " from books " +
                " where purchase_location = 'Amazon'; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Book book = mapRowToBook(rowSet);
            results.add(book);}
        return results;
    }

    @Override
    public List<Book> gotForFree() {
        List<Book> results = new ArrayList<>();
        String sql = " SELECT  book_id, title, subtitle, author, genre, isbn, condition, price, cover_price, format, pages, purchase_location, purchase_date, notes, read_status " +
                " from books " +
                " where price = 0; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Book book = mapRowToBook(rowSet);
            results.add(book);}
        return results;
    }

    @Override
    public List<Book> boughtForSchool() {
        List<Book> results = new ArrayList<>();
        String sql = " SELECT  book_id, title, subtitle, author, genre, isbn, condition, price, cover_price, format, pages, purchase_location, purchase_date, notes, read_status " +
                " from books " +
                " where purchase_location = 'Bought for School/Class'; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Book book = mapRowToBook(rowSet);
            results.add(book);}
        return results;
    }

    //Book Mapper
    private Book mapRowToBook(SqlRowSet rowSet) {
        Boolean read;
        Book result = new Book();
        result.setBookId(rowSet.getInt("book_id"));
        result.setBookTitle(rowSet.getString("title"));
        result.setSubtitle(rowSet.getString("subtitle"));
        result.setAuthor(rowSet.getString("author"));
        result.setGenre(rowSet.getString("genre"));
        result.setCondition(rowSet.getString("condition"));
        result.setPrice(rowSet.getInt("price"));
        result.setCoverPrice(rowSet.getInt("cover_price"));
        result.setFormat(rowSet.getString("format"));
        result.setPages(rowSet.getInt("pages"));
        result.setPurchaseLocation(rowSet.getString("purchase_location"));
        result.setPurchaseDate(rowSet.getString("purchase_date"));
        result.setNotes(rowSet.getString("notes"));
        result.setIsbn(rowSet.getString("isbn"));
        result.setReadStatus(String.valueOf(rowSet.getString("read_status")));

        return result;
    }
}
