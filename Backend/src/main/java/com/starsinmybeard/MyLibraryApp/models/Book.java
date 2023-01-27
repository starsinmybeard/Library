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
    private String[] genres;
    private int averageGoogleReview;
    private int numOfGoogleReviews;
    private String description;
    private String publishedDate;
    private String publisher;


    public Book(){
    }

    public Book(int bookId, String bookTitle, String subtitle, String author, String genre,
                String isbn, String condition, int price, int coverPrice, String format,
                int pages, String purchaseLocation, String purchaseDate,
                String readStatus, String notes, String[] genres, int averageGoogleReview, int numOfGoogleReviews,
                String description, String publishedDate, String publisher) {
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
        this.genres = genres;
        this.averageGoogleReview = averageGoogleReview;
        this.numOfGoogleReviews = numOfGoogleReviews;
        this.description = description;
        this.publishedDate = publishedDate;
        this.publisher = publisher;
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

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public int getAverageGoogleReview() {
        return averageGoogleReview;
    }

    public void setAverageGoogleReview(int averageGoogleReview) {
        this.averageGoogleReview = averageGoogleReview;
    }

    public int getNumOfGoogleReviews() {
        return numOfGoogleReviews;
    }

    public void setNumOfGoogleReviews(int numOfGoogleReviews) {
        this.numOfGoogleReviews = numOfGoogleReviews;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
