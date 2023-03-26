package pl.edu.pwr.ztw.books.Services;

import pl.edu.pwr.ztw.books.Models.Author;
import pl.edu.pwr.ztw.books.Models.Book;
import pl.edu.pwr.ztw.books.Models.BookTransportObject;

import java.util.Collection;

public interface IBooksService {
    public abstract Collection<Book> getBooks();
    public abstract Book getBook(int id);

    public abstract boolean deleteBook(int id);

    public abstract Book createBook(BookTransportObject book);

    public abstract Book updateBook(int id, BookTransportObject book);

}
