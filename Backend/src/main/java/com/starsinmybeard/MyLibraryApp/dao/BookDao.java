package com.starsinmybeard.MyLibraryApp.dao;
import com.starsinmybeard.MyLibraryApp.models.Book;
import java.util.List;


public interface BookDao {
    List<Book> getAllBooks();
    Book getBook(String bookTitle);
    public void addBook(Book book);
}
