package com.starsinmybeard.MyLibraryApp.dao;

import com.starsinmybeard.MyLibraryApp.models.Book;

import java.util.List;

public interface StatisticsDao {
    int numberOfBooks();
    int numberOfAuthors();
    int moneySpent();
    int averagePrice();
    int moneySaved();
    int averagePageCount();
    int hardcoverCount();
    int paperbackCount();
    int totalFromAuthor();
    int totalFromGenre();
    int dayOfMostBuys();
    int numPurchasedFromLocation(String purchaseLocation);
    List<Book> mostExpensiveBooks();

    List<Book> cheapestBooks();
}
