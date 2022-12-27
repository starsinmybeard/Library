package com.starsinmybeard.MyLibraryApp.dao;
import com.starsinmybeard.MyLibraryApp.models.Book;
import java.util.List;


public interface BookDao {
    List<Book> getAllBooks();
    Book getBook(int bookId);
    public void addBook(Book book);

    //Returns List of Books bought at CG Library
    List<Book> boughtFromGarlandCountyLibrary();
    List<Book> boughtFromEbay();
    List<Book> boughtFromAmazon();

}
