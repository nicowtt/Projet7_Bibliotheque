package com.eLibrary.moduleModel.beans;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.library_id_seq")
    @SequenceGenerator(name = "public.library_id_seq", sequenceName = "public.library_id_seq", allocationSize = 1)
    private int id;
    @Column
    private String libraryname;

    @OneToMany(mappedBy = "library") //attribut Library library de BookReservation
    private List<BookReservation> bookReservationList = new ArrayList<>();


    //contructor
    public Library() {
    }

    public Library(String libraryname, List<BookReservation> bookReservationList) {
        this.libraryname = libraryname;
        this.bookReservationList = bookReservationList;
    }

    //getter and setter
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

    public List<BookReservation> getBookReservationList() {
        return bookReservationList;
    }

    public void setBookReservationList(List<BookReservation> bookReservationList) {
        this.bookReservationList = bookReservationList;
    }

    //to string
    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", libraryname='" + libraryname + '\'' +
                ", bookReservationList=" + bookReservationList +
                '}';
    }
}
