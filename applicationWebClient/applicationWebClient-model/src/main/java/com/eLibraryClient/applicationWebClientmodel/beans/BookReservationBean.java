package com.eLibraryClient.applicationWebClientmodel.beans;

public class BookReservationBean {

    private int id;
    private String beginofreservationdate;
    private String endofreservationdate;
    private int extensionofreservation;
    private int user_id;
    private int book_id;
    private int library_id;

    //constructor
    public BookReservationBean() {
    }

    public BookReservationBean(int id, String beginofreservationdate, String endofreservationdate, int extensionofreservation, int user_id, int book_id, int library_id) {
        this.id = id;
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
        return "BookReservationBean{" +
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
