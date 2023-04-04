package pl.edu.pwr.ztw.books.Models;

public class BookTransportObject {

    private static int index = 4;
    private int id;
    private String title;
    private int authorId;
    private int pages;

    public BookTransportObject(String title, int authorId, int pages) {
        this.id = index++;
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
