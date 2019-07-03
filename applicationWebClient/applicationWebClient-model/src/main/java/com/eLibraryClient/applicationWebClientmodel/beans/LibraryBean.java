package com.eLibraryClient.applicationWebClientmodel.beans;

public class LibraryBean {

    private int id;
    private String libraryname;


    private BookReservationBean bookReservations;

    private BookBean books;

    //contructor
    public LibraryBean() {
    }

    public LibraryBean(int id, String libraryname, BookReservationBean bookReservations, BookBean books) {
        this.id = id;
        this.libraryname = libraryname;
        this.bookReservations = bookReservations;
        this.books = books;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibraryname() {
        return libraryname;
    }

    public void setLibraryname(String libraryname) {
        this.libraryname = libraryname;
    }

    public BookReservationBean getBookReservations() {
        return bookReservations;
    }

    public void setBookReservations(BookReservationBean bookReservations) {
        this.bookReservations = bookReservations;
    }

    public BookBean getBooks() {
        return books;
    }

    public void setBooks(BookBean books) {
        this.books = books;
    }
}
