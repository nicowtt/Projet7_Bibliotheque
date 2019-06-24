package com.eLibrary.moduleModel.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String bookname;
    private String bookauthor;
    private String bookpictureurl;
    private String bookdescription;
    private String booklabel;
    private Boolean bookreservation;

    public Book() {
    }

    public Book(String bookname, String bookauthor, String bookpictureurl, String bookdescription, String booklabel, Boolean bookreservation) {
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookpictureurl = bookpictureurl;
        this.bookdescription = bookdescription;
        this.booklabel = booklabel;
        this.bookreservation = bookreservation;
    }

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
    public Boolean getBookreservation() {
        return bookreservation;
    }
    public void setBookreservation(Boolean bookreservation) {
        this.bookreservation = bookreservation;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookauthor='" + bookauthor + '\'' +
                ", bookpictureurl='" + bookpictureurl + '\'' +
                ", bookdescription='" + bookdescription + '\'' +
                ", booklabel='" + booklabel + '\'' +
                ", bookreservation=" + bookreservation +
                '}';
    }
}
