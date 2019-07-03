package com.eLibrary.moduleModel.beans;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.library_id_seq")
    @SequenceGenerator(name = "public.library_id_seq", sequenceName = "public.library_id_seq", allocationSize = 1)
    private int id;
    @Column
    private String libraryname;

    @OneToMany(mappedBy = "library") //attribut Library library from BookReservation
    private Set<BookReservation> bookReservations = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "librarycatalog",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name ="book_id"))
    private Set<Book> books;

    //contructor

    public Library() {
    }

    public Library(String libraryname, Set<BookReservation> bookReservations, Set<Book> books) {
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

    public Set<BookReservation> getBookReservations() {
        return bookReservations;
    }

    public void setBookReservations(Set<BookReservation> bookReservations) {
        this.bookReservations = bookReservations;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
