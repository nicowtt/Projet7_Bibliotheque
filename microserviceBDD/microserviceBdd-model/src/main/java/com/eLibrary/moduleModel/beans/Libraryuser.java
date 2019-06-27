package com.eLibrary.moduleModel.beans;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Libraryuser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.libraryuser_id_seq")
    @SequenceGenerator(name = "public.libraryuser_id_seq", sequenceName = "public.libraryuser_id_seq", allocationSize = 1)
    private int id;
    private String userfirstname;
    private String username;
    private String userpassword;
    private String useremail;

    //constructor
    public Libraryuser() {
    }

    public Libraryuser(String userfirstname, String username, String userpassword, String useremail) {
        this.userfirstname = userfirstname;
        this.username = username;
        this.userpassword = userpassword;
        this.useremail = useremail;
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

    //to string
    @Override
    public String toString() {
        return "Libraryuser{" +
                "id=" + id +
                ", userfirstname='" + userfirstname + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}
