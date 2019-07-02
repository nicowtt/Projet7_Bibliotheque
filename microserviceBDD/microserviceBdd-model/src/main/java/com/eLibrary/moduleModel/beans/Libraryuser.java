package com.eLibrary.moduleModel.beans;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libraryuser")
public class Libraryuser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.libraryuser_id_seq")
    @SequenceGenerator(name = "public.libraryuser_id_seq", sequenceName = "public.libraryuser_id_seq", allocationSize = 1)
    private int id;
    @Column
    private String userfirstname;
    @Column
    private String username;
    @Column
    private String userpassword;
    @Column
    private String useremail;

    @OneToMany(mappedBy = "libraryuser") //attribut Libraryuser libraryuser de BookReservation
    private List<BookReservation> bookReservationList = new ArrayList<>();


    //constructor
    public Libraryuser() {
    }

    public Libraryuser(String userfirstname, String username, String userpassword, String useremail, List<BookReservation> bookReservationList) {
        this.userfirstname = userfirstname;
        this.username = username;
        this.userpassword = userpassword;
        this.useremail = useremail;
        this.bookReservationList = bookReservationList;
    }

    //getter and setter
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

    public List<BookReservation> getBookReservationList() {
        return bookReservationList;
    }

    public void setBookReservationList(List<BookReservation> bookReservationList) {
        this.bookReservationList = bookReservationList;
    }


    //to string
    @Override
    public String toString() {
        return "Libraryuser{" +
                "id=" + id +
                ", userfirstname='" + userfirstname + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", useremail='" + useremail + '\'' +
                ", bookReservationList=" + bookReservationList +
                '}';
    }
}
