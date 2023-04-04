package pl.edu.pwr.ztw.books.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.books.Models.Book;
import pl.edu.pwr.ztw.books.Models.Rental;
import pl.edu.pwr.ztw.books.Models.RentalTransportObject;
import pl.edu.pwr.ztw.books.Services.IBooksService;
import pl.edu.pwr.ztw.books.Services.IRentalsService;

import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
public class RentalController {
    @Autowired
    IRentalsService rentalsService;
    @Autowired
    IBooksService booksService;

    @GetMapping(value = "/rentals")
    public ResponseEntity<Object> getRentals(){
        return new ResponseEntity<>(rentalsService.getRentals(), HttpStatus.OK);
    }

    @GetMapping(value = "/rentals/{id}")
    public ResponseEntity<Object> getRental(@PathVariable int id){
        Rental result = rentalsService.getRental(id);
        if (result == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/rentals")
    public ResponseEntity<Object> createRental(@RequestBody RentalTransportObject rental){
        if (!rentalsService.isBookAvailable(rental.getBookId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else {
            Rental result = rentalsService.createRental(rental);
            if (result == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else{
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        }
    }

    @PutMapping(value = "/rentals/{id}")
    public ResponseEntity<Object> returnBook(@PathVariable int id){
        Rental result = rentalsService.returnBook(id);
        if (result == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/rentals/book/{id}")
    public ResponseEntity<Object> isBookFree(@PathVariable int id){
        Book result = booksService.getBook(id);
        if(result == null){
            return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(rentalsService.isBookAvailable(id), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/rentals/book")
    public ResponseEntity<Object> freeBooks(){
        return new ResponseEntity<>(rentalsService.freeBooks(), HttpStatus.OK);
    }
}
