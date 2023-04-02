package pl.edu.pwr.ztw.books.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.books.Models.Author;
import pl.edu.pwr.ztw.books.Models.AuthorTransportObject;
import pl.edu.pwr.ztw.books.Services.IAuthorsService;

@RestController
public class AuthorsController {

    @Autowired
    IAuthorsService authorsService;

    @GetMapping(value = "/authors")
    public ResponseEntity<Object> getAuthors() {
        return new ResponseEntity<>(authorsService.getAuthors(), HttpStatus.OK);
    }

    @GetMapping(value = "/authors/{id}")
    public ResponseEntity<Object> getAuthor(@PathVariable("id") int id) {
        Author result = authorsService.getAuthor(id);
        if(result == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/authors/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id){
        return new ResponseEntity<>(authorsService.deleteAuthor(id), HttpStatus.OK);
    }

    @PutMapping(value = "/authors")
    public ResponseEntity<Object> createAuthor(@RequestBody AuthorTransportObject author){
        Author result = authorsService.createAuthor(author);
        if (result == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/authors/{id}")
    public ResponseEntity<Object> updateAuthor(@RequestBody AuthorTransportObject author, @PathVariable int id){
        Author result = authorsService.updateAuthor(id, author);
        if(result == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}


