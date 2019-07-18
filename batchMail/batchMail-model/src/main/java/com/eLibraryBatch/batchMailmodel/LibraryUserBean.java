package com.eLibraryBatch.batchMailmodel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class LibraryUserBean {

    private int id;

    @NotBlank
    @Size(max=50)
    private String userfirstname;

    @NotBlank
    @Size(max=50)
    private String username;

    @NotBlank
    @Size(min=2, max = 15, message = "La taille doit être comprise entre 2 et 15 caractères")
    private String userpassword;

    @NotBlank
    private String useremail;

    private Set<BookReservationBean> bookReservations = new HashSet<>();

    // Constructor
    public LibraryUserBean() {
    }

    public LibraryUserBean(int id, @NotBlank @Size(max = 50) String userfirstname, @NotBlank @Size(max = 50) String username, @NotBlank @Size(min = 2, max = 15) String userpassword, @NotBlank String useremail, Set<BookReservationBean> bookReservations) {
        this.id = id;
        this.userfirstname = userfirstname;
        this.username = username;
        this.userpassword = userpassword;
        this.useremail = useremail;
        this.bookReservations = bookReservations;
    }

    //Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public Set<BookReservationBean> getBookReservations() {
        return bookReservations;
    }

    public void setBookReservations(Set<BookReservationBean> bookReservations) {
        this.bookReservations = bookReservations;
    }


    // toString


    @Override
    public String toString() {
        return "LibraryUserBean{" +
                "id=" + id +
                ", userfirstname='" + userfirstname + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", useremail='" + useremail + '\'' +
                ", bookReservations=" + bookReservations +
                '}';
    }
}
