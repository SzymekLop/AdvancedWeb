package pl.edu.pwr.ztw.books.Services;

import pl.edu.pwr.ztw.books.Models.Book;
import pl.edu.pwr.ztw.books.Models.Rental;

import java.util.Collection;
import java.util.Date;

public interface IRentalsService {

    public abstract Collection<Rental> getRentals();
    public abstract Rental getRental(int id);

    public abstract void returnBook(int rentalId);

    public abstract void addRental(int id, Book book, String client, Date rentDate, Date returnDate);
}
