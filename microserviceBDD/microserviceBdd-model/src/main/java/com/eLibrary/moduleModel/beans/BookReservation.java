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
    private String beginOfReservationDate;

    @Column(name = "endofreservationdate")
    private String endOfReservationDate;

    @Column(name = "extensionofreservation")
    private String extensionofreservation;

    @ManyToOne //many reservation for one user
    @JoinColumn(name = "user_id") //fk
//    @JsonIgnore
    private Libraryuser libraryuser;

    @ManyToOne //many reservation for one livre
    @JoinColumn(name = "book_id") //fk
//    @JsonIgnore
    private Book book;

    @ManyToOne //many reservation for one library
    @JoinColumn(name = "library_id") //fk
//    @JsonIgnore
    private Library library;


    //constructor
    public BookReservation() {
    }

    public BookReservation(String beginOfReservationDate, String endOfReservationDate, String extensionofreservation, Libraryuser libraryuser, Book book, Library library) {
        this.beginOfReservationDate = beginOfReservationDate;
        this.endOfReservationDate = endOfReservationDate;
        this.extensionofreservation = extensionofreservation;
        this.libraryuser = libraryuser;
        this.book = book;
        this.library = library;
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeginOfReservationDate() {
        return beginOfReservationDate;
    }

    public void setBeginOfReservationDate(String beginOfReservationDate) {
        this.beginOfReservationDate = beginOfReservationDate;
    }

    public String getEndOfReservationDate() {
        return endOfReservationDate;
    }

    public void setEndOfReservationDate(String endOfReservationDate) {
        this.endOfReservationDate = endOfReservationDate;
    }

    public String getExtensionofreservation() {
        return extensionofreservation;
    }

    public void setExtensionofreservation(String extensionofreservation) {
        this.extensionofreservation = extensionofreservation;
    }

    public Libraryuser getLibraryuser() {
        return libraryuser;
    }

    public void setLibraryuser(Libraryuser libraryuser) {
        this.libraryuser = libraryuser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    //to string
    @Override
    public String toString() {
        return "BookReservation{" +
                "id=" + id +
                ", beginOfReservationDate='" + beginOfReservationDate + '\'' +
                ", endOfReservationDate='" + endOfReservationDate + '\'' +
                ", extensionofreservation='" + extensionofreservation + '\'' +
                ", libraryuser=" + libraryuser +
                ", book=" + book +
                ", library=" + library +
                '}';
    }
}
