package pl.edu.pwr.ztw.books.Models;

import java.util.Date;

public class RentalTransportObject {

    private int id;
    private int bookId;
    private String client;
    private Date rentDate;
    private Date returnDate;

    public RentalTransportObject(int id, int bookId, String client, Date rentDate, Date returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.client = client;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public String getClient() {
        return client;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
