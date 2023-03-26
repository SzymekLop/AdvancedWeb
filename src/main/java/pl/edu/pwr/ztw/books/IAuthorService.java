package pl.edu.pwr.ztw.books;

import java.util.Collection;

public interface IAuthorService {

    public abstract Collection<Author> getAuthors();
    public abstract Author getAuthor(int id);

    public abstract void deleteAuthor(int id);

    public abstract void addAuthor(int id, String name, String surname);
}
