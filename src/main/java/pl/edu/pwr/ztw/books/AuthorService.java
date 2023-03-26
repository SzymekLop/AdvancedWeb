package pl.edu.pwr.ztw.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthorService implements IAuthorService{

    public static List<Author> authorsRepo = new ArrayList<>();
    static {
        authorsRepo.add(new Author(1,"Henryk", "Sienkiwicz"));
        authorsRepo.add(new Author(2,"Stanisław", "Reymontz"));
        authorsRepo.add(new Author(3,"Adam", "Mickiewicz"));
    }
    @Override
    public Collection<Author> getAuthors() {
        return authorsRepo;
    }

    @Override
    public Author getAuthor(int id) {
        return authorsRepo.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteAuthor(int id) {
        authorsRepo.remove(getAuthor(id));
    }

    @Override
    public void addAuthor(int id, String name, String surname) {
        authorsRepo.add(new Author(id, name, surname));
    }
}
