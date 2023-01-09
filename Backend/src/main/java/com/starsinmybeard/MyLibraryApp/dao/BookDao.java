package com.starsinmybeard.MyLibraryApp.dao;
import com.starsinmybeard.MyLibraryApp.models.Book;
import java.util.List;


public interface BookDao {
    List<Book> getAllBooks();
    Book getBook(int bookId);
    public void addBook(Book book);

    //List of books Based off purchase location
    List<Book> boughtFromGarlandCounty();
    List<Book> boughtFromEbay();
    List<Book> boughtFromAmazon();
    List<Book> gotForFree();
    List<Book> boughtForSchool();
}
