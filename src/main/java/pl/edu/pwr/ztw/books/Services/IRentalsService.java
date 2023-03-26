package pl.edu.pwr.ztw.books.Services;

import pl.edu.pwr.ztw.books.Models.Rental;
import pl.edu.pwr.ztw.books.Models.RentalTransportObject;

import java.util.Collection;

public interface IRentalsService {

    public abstract Collection<Rental> getRentals();
    public abstract Rental getRental(int id);

    public abstract Rental returnBook(int id);

    public abstract Rental createRental(RentalTransportObject rental);

    public boolean isBookAvailable(int bookId);
}
