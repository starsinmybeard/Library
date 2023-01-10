package com.starsinmybeard.MyLibraryApp.controllers;
import com.starsinmybeard.MyLibraryApp.dao.JdbcStatisticsDao;
import com.starsinmybeard.MyLibraryApp.dao.StatisticsDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class StatisticsController {
    private StatisticsDao statisticsDao;
    public StatisticsController(JdbcStatisticsDao statisticsDao){
        this.statisticsDao = statisticsDao;
    }

    @RequestMapping(path = "/numofbooks", method = RequestMethod.GET)
    public int getAllBooks(){
        return this.statisticsDao.numberOfBooks();
    };

}
