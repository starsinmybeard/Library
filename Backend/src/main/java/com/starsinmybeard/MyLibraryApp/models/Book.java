package com.starsinmybeard.MyLibraryApp.models;

public class Book {
    private int bookId;
    private String bookTitle;
    private String subtitle;
    private String author;
    private String genre;
    private String isbn;
    private String condition;
    private int price;
    private int coverPrice;
    //Hard or soft-cover
    private String format;
    private int pages;
    private String purchaseLocation;
    private String purchaseDate;
    private String readStatus;
    private String notes;


    public Book(){
    }

    public Book(int bookId, String bookTitle, String subtitle, String author, String genre,
                String isbn, String condition, int price, int coverPrice, String format,
                int pages, String purchaseLocation, String purchaseDate,
                String readStatus, String notes) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.subtitle = subtitle;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.condition = condition;
        this.price = price;
        this.coverPrice = coverPrice;
        this.format = format;
        this.pages = pages;
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

    public int getCoverPrice() {return coverPrice;}
    public void setCoverPrice(int coverPrice) {this.coverPrice = coverPrice;}

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
