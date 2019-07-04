package com.eLibrary.moduleModel.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.book_id_seq")
    @SequenceGenerator(name = "public.book_id_seq", sequenceName = "public.book_id_seq", allocationSize = 1)
    private int id;
    @Column
    private String bookname;
    @Column
    private String bookauthor;
    @Column
    private String bookpictureurl;
    @Column
    private String bookdescription;
    @Column
    private String booklabel;
    @Column
    private int nbrbookiteration;
    @Column
    private int nbrbookiterationnotreserved;
    @Column
    private Boolean allbookreserved;

//    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER) //attribut Book book from BookReservation
//    private Set<BookReservation> bookReservations = new HashSet<>();

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER) //attribut Book books from library
    private Set<Library> libraries = new HashSet<>();


    //Constructor
    public Book() {
    }

    public Book(String bookname, String bookauthor, String bookpictureurl, String bookdescription, String booklabel, int nbrbookiteration, int nbrbookiterationnotreserved, Boolean allbookreserved, Set<Library> libraries) {
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookpictureurl = bookpictureurl;
        this.bookdescription = bookdescription;
        this.booklabel = booklabel;
        this.nbrbookiteration = nbrbookiteration;
        this.nbrbookiterationnotreserved = nbrbookiterationnotreserved;
        this.allbookreserved = allbookreserved;
        this.libraries = libraries;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookpictureurl() {
        return bookpictureurl;
    }

    public void setBookpictureurl(String bookpictureurl) {
        this.bookpictureurl = bookpictureurl;
    }

    public String getBookdescription() {
        return bookdescription;
    }

    public void setBookdescription(String bookdescription) {
        this.bookdescription = bookdescription;
    }

    public String getBooklabel() {
        return booklabel;
    }

    public void setBooklabel(String booklabel) {
        this.booklabel = booklabel;
    }

    public int getNbrbookiteration() {
        return nbrbookiteration;
    }

    public void setNbrbookiteration(int nbrbookiteration) {
        this.nbrbookiteration = nbrbookiteration;
    }

    public int getNbrbookiterationnotreserved() {
        return nbrbookiterationnotreserved;
    }

    public void setNbrbookiterationnotreserved(int nbrbookiterationnotreserved) {
        this.nbrbookiterationnotreserved = nbrbookiterationnotreserved;
    }

    public Boolean getAllbookreserved() {
        return allbookreserved;
    }

    public void setAllbookreserved(Boolean allbookreserved) {
        this.allbookreserved = allbookreserved;
    }

    public Set<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(Set<Library> libraries) {
        this.libraries = libraries;
    }
}
