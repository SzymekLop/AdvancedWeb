package pl.edu.pwr.ztw.books.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.books.Models.Book;
import pl.edu.pwr.ztw.books.Models.BookTransportObject;
import pl.edu.pwr.ztw.books.Services.IBooksService;

@RestController
public class BooksController {
    @Autowired
    IBooksService booksService;

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks(){
        return new ResponseEntity<>(booksService.getBooks(), HttpStatus.OK);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id){
        Book result = booksService.getBook(id);
        if (result == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id){
        return new ResponseEntity<>(booksService.deleteBook(id), HttpStatus.OK);
    }

    @PutMapping(value = "/books")
    public ResponseEntity<Object> createBook(@RequestBody BookTransportObject book){
        Book result = booksService.createBook(book);
        if (result == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@RequestBody BookTransportObject book, @PathVariable int id){
        Book result = booksService.updateBook(id, book);
        if(result == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}

