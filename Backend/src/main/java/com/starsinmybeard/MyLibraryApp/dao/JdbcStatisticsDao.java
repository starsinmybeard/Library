package com.starsinmybeard.MyLibraryApp.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
        return 1;
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
                " SELECT COUNT(price) " +
                        "    FROM books; ";
        int avg = jdbcTemplate.queryForObject(sql, Integer.class);
        return avg;

    }

    @Override
    public int moneySaved(){
        return 1;
    }

    @Override
    public int averagePageCount(){
        return 1;
    }

    @Override
    public int hardcoverCount(){
        return 1;
    }

    @Override
    public int paperbackCount(){
        return 1;
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
}
