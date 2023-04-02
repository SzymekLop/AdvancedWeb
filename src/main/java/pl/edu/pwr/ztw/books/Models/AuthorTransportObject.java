package pl.edu.pwr.ztw.books.Models;

import nonapi.io.github.classgraph.json.Id;

public class AuthorTransportObject {

    private static int INDEX = 4;
    private int id;
    private String name;
    private String surname;

    public AuthorTransportObject(String name, String surname) {
        this.id = INDEX++;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
