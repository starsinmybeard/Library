package com.starsinmybeard.MyLibraryApp.models;

public class Book {
    private int bookId;
    private String bookTitle;
    private String author;
    private String genre;
    private int isbn;
    private String condition;
    private int price;
    private String purchaseLocation;
    private String purchaseDate;
    private boolean readStatus;
    private String notes;

    public Book(){
    }

    public Book(int bookId, String bookTitle, String author, String genre,
                int isbn, String condition, int price, String purchaseLocation, String purchaseDate,
                boolean readStatus, String notes) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.condition = condition;
        this.price = price;
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

    public String getBookTitle() {
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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
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

    public boolean isReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean readStatus) {
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
}
