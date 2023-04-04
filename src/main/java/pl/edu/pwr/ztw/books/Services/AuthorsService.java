package pl.edu.pwr.ztw.books.Services;

import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.books.Models.Author;
import pl.edu.pwr.ztw.books.Models.AuthorTransportObject;

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
    public Author createAuthor(AuthorTransportObject author) {
        Author result = new Author(author.getId(), author.getName(), author.getSurname());
        authorsRepo.add(result);
        return result;
    }

    @Override
    public Author updateAuthor(int id, AuthorTransportObject author) {

        Author result = getAuthor(id);

        if(result != null){

            result.setName(author.getName());
            result.setSurname(author.getSurname());
        }

        return result;
    }
}
