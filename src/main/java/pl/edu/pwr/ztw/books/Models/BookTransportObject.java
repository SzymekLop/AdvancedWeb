package pl.edu.pwr.ztw.books.Models;

public class BookTransportObject {

    private int id;
    private String title;
    private int authorId;
    private int pages;

    public BookTransportObject(int id, String title, int authorId, int pages) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getPages() {
        return pages;
    }
}
