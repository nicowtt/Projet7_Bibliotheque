package com.eLibrary.moduleModel.beans;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;

@Entity
@Table(name = "bookreservation")
public class BookReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.book_id_seq")
    @SequenceGenerator(name = "public.book_id_seq", sequenceName = "public.book_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "beginofreservationdate")
    private String beginofreservationdate;

    @Column(name = "endofreservationdate")
    private String endofreservationdate;

    @Column(name = "extensionofreservation")
    private int extensionofreservation;

    @Column
    private int user_id;

    @Column
    private int book_id;

    @Column
    private int library_id;

//    @ManyToOne //many reservation for one user
//    @JoinColumn(name = "user_id") //fk
////    @JsonIgnore
//    private Libraryuser libraryuser;

//    @ManyToOne //many reservation for one livre
//    @JoinColumn(name = "book_id") //fk
////    @JsonIgnore
//    private Book book;

//    @ManyToOne //many reservation for one library
//    @JoinColumn(name = "library_id") //fk
////    @JsonIgnore
//    private Library library;


    //constructor
    public BookReservation() {
    }

    public BookReservation(String beginofreservationdate, String endofreservationdate, int extensionofreservation, int user_id, int book_id, int library_id) {
        this.beginofreservationdate = beginofreservationdate;
        this.endofreservationdate = endofreservationdate;
        this.extensionofreservation = extensionofreservation;
        this.user_id = user_id;
        this.book_id = book_id;
        this.library_id = library_id;
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeginofreservationdate() {
        return beginofreservationdate;
    }

    public void setBeginofreservationdate(String beginofreservationdate) {
        this.beginofreservationdate = beginofreservationdate;
    }

    public String getEndofreservationdate() {
        return endofreservationdate;
    }

    public void setEndofreservationdate(String endofreservationdate) {
        this.endofreservationdate = endofreservationdate;
    }

    public int getExtensionofreservation() {
        return extensionofreservation;
    }

    public void setExtensionofreservation(int extensionofreservation) {
        this.extensionofreservation = extensionofreservation;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }

    //to string
    @Override
    public String toString() {
        return "BookReservation{" +
                "id=" + id +
                ", beginofreservationdate='" + beginofreservationdate + '\'' +
                ", endofreservationdate='" + endofreservationdate + '\'' +
                ", extensionofreservation=" + extensionofreservation +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", library_id=" + library_id +
                '}';
    }
}
