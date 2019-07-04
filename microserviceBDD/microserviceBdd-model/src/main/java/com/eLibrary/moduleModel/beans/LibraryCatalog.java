package com.eLibrary.moduleModel.beans;

import javax.persistence.*;

@Entity
@Table(name = "librarycatalog")
public class LibraryCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.book_id_seq")
    @SequenceGenerator(name = "public.book_id_seq", sequenceName = "public.book_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "library_id")
    private int libraryId;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "bookiteration")
    private int bookIteration;

    //contructor
    public LibraryCatalog() {
    }

    public LibraryCatalog(int libraryId, int bookId, int bookIteration) {
        this.libraryId = libraryId;
        this.bookId = bookId;
        this.bookIteration = bookIteration;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookIteration() {
        return bookIteration;
    }

    public void setBookIteration(int bookIteration) {
        this.bookIteration = bookIteration;
    }
}
