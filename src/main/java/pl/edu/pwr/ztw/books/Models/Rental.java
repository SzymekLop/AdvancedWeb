package pl.edu.pwr.ztw.books.Models;

import java.util.Date;

public class Rental {
    private int id;
    private Book book;
    private String client;
    private Date rentDate;
    private Date returnDate;
    private boolean isReturned;

    public Rental(int id, Book book, String client, Date rentDate, Date returnDate, boolean isReturned) {
        this.id = id;
        this.book = book;
        this.client = client;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
