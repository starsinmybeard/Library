package com.starsinmybeard.MyLibraryApp.controllers;
import com.starsinmybeard.MyLibraryApp.dao.BookDao;
import com.starsinmybeard.MyLibraryApp.models.Book;
import org.springframework.web.bind.annotation.*;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;


@RestController
public class LibraryController {
    private BookDao bookDao;


    public LibraryController(BookDao bookDao){
        this.bookDao = bookDao;
    }

    //TODO finish return statement
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return this.bookDao.getAllBooks();
    }



    @RequestMapping(path = "/", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book){
            bookDao.addBook(book);
    }

    @RequestMapping(path = "/{title}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String title) {
        Book bookToReturn = new Book();
        bookToReturn = bookDao.getBook(title);
        return bookToReturn;
    }





}
