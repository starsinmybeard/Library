package com.starsinmybeard.MyLibraryApp.controllers;
import com.starsinmybeard.MyLibraryApp.dao.BookDao;
import com.starsinmybeard.MyLibraryApp.dao.JdbcBooksDao;
import com.starsinmybeard.MyLibraryApp.models.Book;
import org.springframework.web.bind.annotation.*;
import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class LibraryController {
    private BookDao bookDao;
    public LibraryController(JdbcBooksDao bookDao){
        this.bookDao = bookDao;
    }

    //TODO finish return statement
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return this.bookDao.getAllBooks();
    };


    @RequestMapping(path = "/AddBook", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book){
            bookDao.addBook(book);
    };

    @RequestMapping(path = "/Book/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable int bookId) {
        Book bookToReturn = new Book();
        bookToReturn = bookDao.getBook(bookId);
        return bookToReturn;
    };

    @RequestMapping(path = "/Book/{bookId}", method = RequestMethod.PUT)
    public void updateBook(@RequestBody Book book){
        bookDao.updateBook(book);
    };

    //Get Books Based off Purchase Location
    //
    //
    @RequestMapping(path = "/GarlandCounty", method = RequestMethod.GET)
    public List<Book> boughtFromGarlandCounty(){
        return this.bookDao.boughtFromGarlandCounty();
    };

    @RequestMapping(path = "/Ebay", method = RequestMethod.GET)
    public List<Book> boughtFromEbay(){
        return this.bookDao.boughtFromEbay();
    };

    @RequestMapping(path = "/Amazon", method = RequestMethod.GET)
    public List<Book> boughtFromAmazon(){
        return this.bookDao.boughtFromAmazon();
    };

    @RequestMapping(path = "/freebooks", method = RequestMethod.GET)
    public List<Book> gotForFree(){
        return this.bookDao.gotForFree();
    };

    @RequestMapping(path = "/schoolbooks", method = RequestMethod.GET)
    public List<Book> boughtForSchool(){
        return this.bookDao.boughtForSchool();
    };
    //
    //
    //





    
}
