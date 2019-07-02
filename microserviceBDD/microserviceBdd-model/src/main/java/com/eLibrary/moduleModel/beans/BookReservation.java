package com.eLibrary.moduleModel.beans;

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

    @Column(name = "user_id")
    private int userId;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "library_id")
    private int libraryId;


    //constructor
    public BookReservation() {
    }

    public BookReservation(String beginOfReservationDate, String endOfReservationDate, String extensionofreservation, int userId, int bookId, int libraryId) {
        this.beginOfReservationDate = beginOfReservationDate;
        this.endOfReservationDate = endOfReservationDate;
        this.extensionofreservation = extensionofreservation;
        this.userId = userId;
        this.bookId = bookId;
        this.libraryId = libraryId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }
}
