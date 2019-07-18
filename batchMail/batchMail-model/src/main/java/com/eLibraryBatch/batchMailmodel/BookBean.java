package com.eLibraryBatch.batchMailmodel;

import java.util.HashSet;
import java.util.Set;

public class BookBean {

    private int id;
    private String bookname;
    private String bookauthor;
    private String bookpictureurl;
    private String bookdescription;
    private String booklabel;
    private Boolean allbookreserved;

    // LibraryBean
    private Set<LibraryBean> libraries = new HashSet<>();

    //Constructor
    public BookBean() {
    }

    public BookBean(int id, String bookname, String bookauthor, String bookpictureurl,
                    String bookdescription, String booklabel, Boolean allbookreserved,
                    Set<LibraryBean> libraries) {
        this.id = id;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookpictureurl = bookpictureurl;
        this.bookdescription = bookdescription;
        this.booklabel = booklabel;
        this.allbookreserved = allbookreserved;
        this.libraries = libraries;
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

    public Boolean getAllbookreserved() {
        return allbookreserved;
    }

    public void setAllbookreserved(Boolean allbookreserved) {
        this.allbookreserved = allbookreserved;
    }

    public Set<LibraryBean> getLibraries() {
        return libraries;
    }

    public void setLibraries(Set<LibraryBean> libraries) {
        this.libraries = libraries;
    }
}
