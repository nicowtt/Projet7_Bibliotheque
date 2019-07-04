package com.eLibrary.moduleModel.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Embeddable
@Table(name = "librarycatalog")
public class LibraryCatalog {


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
