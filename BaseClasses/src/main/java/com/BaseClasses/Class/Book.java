package com.BaseClasses.Class;

/**
 * Created by cowlog on 18-2-9.
 * Implement book.
 */
public class Book {
    private String id;
    private int numPage;
    private String ISBN;
    private boolean isRent;

    public boolean isRent() {
        return isRent;
    }

    String getId() {
        return id;
    }


    public Book(String id, int numPage, String ISBN, boolean isRent) {
        this.id = id;
        this.numPage = numPage;
        this.ISBN = ISBN;
        this.isRent = isRent;
    }

    void print() {
        System.out.println("ID: " + id
            + "\tPages: " + numPage
            + "\tISBN: " + ISBN
            + "\tIs rent: " + isRent);
    }

    public void rent() {
        this.isRent = true;
    }

    public void returned() {
        this.isRent = false;
    }
}
