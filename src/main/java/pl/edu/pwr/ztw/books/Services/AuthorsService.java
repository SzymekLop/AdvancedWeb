package pl.edu.pwr.ztw.books.Services;

import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Models.Author;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthorsService implements IAuthorsService {

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
    public boolean deleteAuthor(int id) {
        authorsRepo.remove(getAuthor(id));
        return true;
    }

    @Override
    public Author createAuthor(Author author) {
        authorsRepo.add(author);
        return author;
    }

    @Override
    public Author updateAuthor(int id, Author author) {

        Author result = getAuthor(id);

        if(author != null){

            author.setName(author.getName());
            author.setSurname(author.getSurname());
        }

        return result;
    }
}
