package pl.edu.pwr.ztw.books.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Models.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RentalsService implements IRentalsService{
    @Autowired
    IBooksService booksService;
    private static List<Rental> rentalsRepo = new ArrayList<>();
    static {
    }
    @Override
    public Collection<Rental> getRentals() {
        return rentalsRepo;
    }

    @Override
    public Rental getRental(int id) {
        return rentalsRepo.stream()
                .filter(r -> r.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public Rental returnBook(int id) {
        Rental result = getRental(id);
        if(result == null){
            return null;
        }
        else{
            result.getBook().setAvailable(true);
            result.setReturned(true);
            return result;
        }
    }

    @Override
    public Rental createRental(RentalTransportObject rental) {
        Book book = booksService.getBook(rental.getBookId());
        if(book == null){
            return null;
        }
        book.setAvailable(false);
        Rental result = new Rental(rental.getId(), book, rental.getClient(), rental.getRentDate(), rental.getReturnDate(), false);
        rentalsRepo.add(result);
        return result;
    }

    @Override
    public boolean isBookAvailable(int bookId) {
        Book book = booksService.getBook(bookId);
        if(book == null){
            return false;
        }
        else{
            return book.isAvailable();
        }
    }
}
