package pl.edu.pwr.ztw.books.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Models.Author;
import pl.edu.pwr.ztw.books.Models.Book;
import pl.edu.pwr.ztw.books.Models.BookTransportObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class BooksService implements IBooksService {

    @Autowired
    IAuthorsService authorsService;
    private static List<Book> booksRepo = new ArrayList<>();
    static {
        booksRepo.add(new Book(1,"Potop", AuthorsService.authorsRepo.get(0), 936));
        booksRepo.add(new Book(2,"Wesele", AuthorsService.authorsRepo.get(1), 150));
        booksRepo.add(new Book(3,"Dziady", AuthorsService.authorsRepo.get(2), 292));
    }
    @Override
    public Collection<Book> getBooks() {
        return booksRepo;
    }

    @Override
    public Book getBook(int id) {
        return booksRepo.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean deleteBook(int id) {
        booksRepo.remove(getBook(id));
        return true;
    }

    @Override
    public Book createBook(BookTransportObject book) {
        Author author = authorsService.getAuthor(book.getAuthorId());
        if(author == null){
            return null;
        }
        Book result = new Book(book.getId(), book.getTitle(), author, book.getPages());
        booksRepo.add(result);
        return result;
    }

    @Override
    public Book updateBook(int id, BookTransportObject book) {

        Book editedBook = getBook(id);
        Author author = authorsService.getAuthor(book.getAuthorId());
        if(editedBook != null && author != null) {

            editedBook.setTitle(book.getTitle());
            editedBook.setPages(book.getPages());
            editedBook.setAuthor(author);

            return editedBook;
        }
        else{
            return null;
        }
    }
}
