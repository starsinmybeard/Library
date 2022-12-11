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
                "insert into books(title, author, genre, isbn, condition, price, " +
                        "purchase_location, purchase_date, read_status, notes)" +
                        " Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql, book.getBookTitle(), book.getAuthor(),
                book.getGenre(), book.getIsbn(),
                book.getCondition(), book.getPrice(), book.getPurchaseLocation(), book.getPurchaseDate(),
                book.isReadStatus(), book.getNotes());
    };

    //Returns List of All Books
    @Override
    public List<Book> getAllBooks() {
        List<Book> results = new ArrayList<>();

        String sql = " SELECT  book_id, title, author, genre, isbn, condition, price, purchase_location, purchase_date, notes, read_status " +
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
    public Book getBook(String bookTitle) {
        Book result = new Book();

        String sql =
                " select title, author, genre, isbn, condition, price, purchase_location, purchase_date, notes, read_status " +
                " FROM books " +
                " Where title = ?; ";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, bookTitle);

        while(rowSet.next()){
            Book book = mapRowToBook(rowSet);
            result = book;
        }

        return result;
    }






    //Book Mapper
    private Book mapRowToBook(SqlRowSet rowSet) {
        Book result = new Book();
        result.setBookId(rowSet.getInt("book_id"));
        result.setBookTitle(rowSet.getString("title"));
        result.setAuthor(rowSet.getString("author"));
        result.setGenre(rowSet.getString("genre"));
        result.setCondition(rowSet.getString("condition"));
        result.setPrice(rowSet.getInt("price"));
        result.setPurchaseLocation(rowSet.getString("purchase_location"));
        result.setPurchaseDate(rowSet.getString("purchase_date"));
        result.setNotes(rowSet.getString("notes"));
        result.setIsbn(rowSet.getInt("isbn"));
        result.setReadStatus(rowSet.getBoolean("read_status"));

        return result;
    }

}
