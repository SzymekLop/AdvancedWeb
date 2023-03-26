package pl.edu.pwr.ztw.books;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class BooksService implements IBooksService {
    private static List<Book> booksRepo = new ArrayList<>();
    static {
        booksRepo.add(new Book(1,"Potop", AuthorService.authorsRepo.get(0), 936));
        booksRepo.add(new Book(2,"Wesele", AuthorService.authorsRepo.get(1), 150));
        booksRepo.add(new Book(3,"Dziady", AuthorService.authorsRepo.get(2), 292));
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
    public void deleteBook(int id) {
        booksRepo.remove(getBook(id));
    }

    @Override
    public void addBook(int id, String title, Author author, int pages) {
        booksRepo.add(new Book(id, title, author, pages));
    }
}
