package com.starsinmybeard.MyLibraryApp.dao;

public interface StatisticsDao {
    int numberOfBooks();
    int numberOfAuthors();

    int moneySpent();

    int averageCost();

    int moneySaved();

    int averagePageCount();

    int hardcoverCount();

    int paperbackCount();

    int totalFromAuthor();

    int totalFromGenre();

    int dayOfMostBuys();
}
