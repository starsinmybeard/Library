package com.starsinmybeard.MyLibraryApp.models;

public class Book {
    private int bookId;
    private String bookTitle;
    private String author;
    private String genre;
    private String isbn;
    private String condition;
    private int price;
    //Hard or soft-cover
    private String format;
    private String purchaseLocation;
    private String purchaseDate;
    private String readStatus;
    private String notes;

    public Book(){
    }

    public Book(int bookId, String bookTitle, String author, String genre,
                String isbn, String condition, int price, String format, String purchaseLocation, String purchaseDate,
                String readStatus, String notes) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.condition = condition;
        this.price = price;
        this.format = format;
        this.purchaseLocation = purchaseLocation;
        this.purchaseDate = purchaseDate;
        this.readStatus = readStatus;
        this.notes = notes;
    }


    //Getters and setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getbookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPurchaseLocation() {
        return purchaseLocation;
    }

    public void setPurchaseLocation(String purchaseLocation) {
        this.purchaseLocation = purchaseLocation;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
