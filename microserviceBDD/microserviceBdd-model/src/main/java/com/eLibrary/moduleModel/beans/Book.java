package com.eLibrary.moduleModel.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
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

    @OneToMany(mappedBy = "book") //attribut Book book de BookReservation
    private List<BookReservation> bookReservationList = new ArrayList<>();


    //Constructor
    public Book() {
    }

    public Book(String bookname, String bookauthor, String bookpictureurl, String bookdescription, String booklabel, int nbrbookiteration, int nbrbookiterationnotreserved, Boolean allbookreserved) {
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookpictureurl = bookpictureurl;
        this.bookdescription = bookdescription;
        this.booklabel = booklabel;
        this.nbrbookiteration = nbrbookiteration;
        this.nbrbookiterationnotreserved = nbrbookiterationnotreserved;
        this.allbookreserved = allbookreserved;
    }
    //getter and setter
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

    //to string
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookauthor='" + bookauthor + '\'' +
                ", bookpictureurl='" + bookpictureurl + '\'' +
                ", bookdescription='" + bookdescription + '\'' +
                ", booklabel='" + booklabel + '\'' +
                ", nbrbookiteration=" + nbrbookiteration +
                ", nbrbookiterationnotreserved=" + nbrbookiterationnotreserved +
                ", allbookreserved=" + allbookreserved +
                ", bookReservationList=" + bookReservationList +
                '}';
    }
}
