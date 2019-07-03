package com.eLibrary.moduleModel.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "libraryuser") //attribut Libraryuser libraryuser from BookReservation
    @JsonManagedReference
    private Set<BookReservation> bookReservations; //todo 0.5 bug: quand cette relation existe je ne peux plus ecrire un nouvel utilisateur

    //constructor
    public Libraryuser() {
    }

    public Libraryuser(String userfirstname, String username, String userpassword, String useremail, Set<BookReservation> bookReservations) {
        this.userfirstname = userfirstname;
        this.username = username;
        this.userpassword = userpassword;
        this.useremail = useremail;
        this.bookReservations = bookReservations;
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

    public Set<BookReservation> getBookReservations() {
        return bookReservations;
    }

    public void setBookReservations(Set<BookReservation> bookReservations) {
        this.bookReservations = bookReservations;
    }
}
