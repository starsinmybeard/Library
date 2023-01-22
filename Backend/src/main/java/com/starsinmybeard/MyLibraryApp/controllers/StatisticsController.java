package com.starsinmybeard.MyLibraryApp.controllers;
import com.starsinmybeard.MyLibraryApp.dao.JdbcStatisticsDao;
import com.starsinmybeard.MyLibraryApp.dao.StatisticsDao;
import com.starsinmybeard.MyLibraryApp.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class StatisticsController {
    private StatisticsDao statisticsDao;
    public StatisticsController(JdbcStatisticsDao statisticsDao){
        this.statisticsDao = statisticsDao;
    }

    @RequestMapping(path = "/stats/BookCount", method = RequestMethod.GET)
    public int bookCount(){
        return this.statisticsDao.numberOfBooks();
    };

    @RequestMapping(path = "/stats/AuthorCount", method = RequestMethod.GET)
    public int authorCount(){
        return this.statisticsDao.numberOfAuthors();
    };

    @RequestMapping(path = "/stats/MoneySpent", method = RequestMethod.GET)
    public int moneySpent(){
        return this.statisticsDao.moneySpent();
    };

    @RequestMapping(path = "/stats/MoneySaved", method = RequestMethod.GET)
    public int moneySaved(){
        return this.statisticsDao.moneySaved();
    };

    @RequestMapping(path = "/stats/AveragePrice", method = RequestMethod.GET)
    public int averagePrice(){
        return this.statisticsDao.averagePrice();
    };

    @RequestMapping(path = "/stats/AvgPageCount", method = RequestMethod.GET)
    public int avgPageCount(){
        return this.statisticsDao.averagePageCount();
    };

    @RequestMapping(path = "/stats/HardcoverCount", method = RequestMethod.GET)
    public int hardcoverCount(){
        return this.statisticsDao.hardcoverCount();
    };

    @RequestMapping(path = "/stats/PaperbackCount", method = RequestMethod.GET)
    public int paperbackCount(){
        return this.statisticsDao.paperbackCount();
    };

    @RequestMapping(path = "/stats/Priciest", method = RequestMethod.GET)
    public List<Book> mostExpensiveBooks() {
        return this.statisticsDao.mostExpensiveBooks();
    };

    @RequestMapping(path = "/stats/Cheapest", method = RequestMethod.GET)
    public List<Book> cheapestBooks() {
        return this.statisticsDao.cheapestBooks();
    };





}
