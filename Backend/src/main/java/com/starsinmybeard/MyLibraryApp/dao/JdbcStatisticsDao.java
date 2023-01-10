package com.starsinmybeard.MyLibraryApp.dao;
import com.starsinmybeard.MyLibraryApp.models.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


// SQL SYNTAX
//      SELECT COUNT(column_name)
//      FROM table_name
//      WHERE condition;

@Component
public class JdbcStatisticsDao implements StatisticsDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcStatisticsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int numberOfBooks(){
        String sql =
                " SELECT COUNT(*) from books; ";
        int result = jdbcTemplate.queryForObject(sql, Integer.class);
        return result;
    }

    @Override
    public int numberOfAuthors(){
        String sql =
                " SELECT COUNT(author) from books; ";
        int result = jdbcTemplate.queryForObject(sql, Integer.class);
        return result;
    }

    @Override
    public int moneySpent(){
        String sql =
                " SELECT SUM(price) " +
                        " FROM books; ";
        int sum = jdbcTemplate.queryForObject(sql, Integer.class);
        return sum;

    }

    @Override
    public int averageCost() {
        String sql =
                " SELECT AVG(price) " +
                        "    FROM books; ";
        int avg = jdbcTemplate.queryForObject(sql, Integer.class);
        return avg;

    }

    @Override
    public int moneySaved(){
        String moneySpent=
                " SELECT SUM(price) " +
                " FROM books; ";
        int totalSpent = jdbcTemplate.queryForObject(moneySpent, Integer.class);

        String coverPrice =
                " SELECT SUM(cover_price) " +
                " FROM books; ";
        int totalCoverPrice = jdbcTemplate.queryForObject(coverPrice, Integer.class);
        return totalCoverPrice - totalSpent;
    }

    @Override
    public int averagePageCount(){
        String sql =
                " SELECT AVG(pages) " +
                        " FROM books; ";
        int averagePageCount = jdbcTemplate.queryForObject(sql, Integer.class);
        return averagePageCount;
    }

    @Override
    public int hardcoverCount(){
        String sql =
                        " SELECT COUNT(*) " +
                        " FROM books " +
                        " WHERE format = 'Hardcover'; ";
        int hardcoverCount = jdbcTemplate.queryForObject(sql, Integer.class);
        return hardcoverCount;
    }

    @Override
    public int paperbackCount(){
        String sql =
                " SELECT COUNT(*) " +
                        " FROM books " +
                        " WHERE format = 'Paperback'; ";
        int paperbackCount = jdbcTemplate.queryForObject(sql, Integer.class);
        return paperbackCount;
    }

    @Override
    public int totalFromAuthor(){
        return 1;
    }

    @Override
    public int totalFromGenre(){
        return 1;
    }

    @Override
    public int dayOfMostBuys(){
        return 12/20/2020;
    }

    @Override
    public int numPurchasedFromLocation(String purchaseLocation){
        String sql =
                " SELECT COUNT(*) " +
                " FROM books " +
                " WHERE purchase_location = ? ;";
        int number = jdbcTemplate.queryForObject(sql, Integer.class, purchaseLocation);
        return number;
    }

    @Override
    public List<Book> mostExpensiveBooks(){
        List<Book> mostExpensive = new ArrayList<>();
        String sql =
                " SELECT * " +
                " From books " +
                " where price = (SELECT MAX(price) FROM books) ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Book result = mapRowToBook(rowSet);
            mostExpensive.add(result);
        }
        return mostExpensive;
    }

    @Override
    public List<Book> cheapestBooks(){
        List<Book> cheapest = new ArrayList<>();
        String sql =
                " SELECT * " +
                        " From books " +
                        " where price = (SELECT MIN(price) FROM books WHERE price > 0) ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Book result = mapRowToBook(rowSet);
            cheapest.add(result);
        }
        return cheapest;
    }


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
