package com.eLibraryClient.applicationWebClientmodel.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LibraryUserBean {

    private int id;

    @NotBlank
    @Size(max=50)
    private String userfirstname;

    @NotBlank
    @Size(max=50)
    private String username;

    @NotBlank
    @Size(min=2, max = 15)
    private String userpassword;

    @NotBlank
    private String useremail;

    // Constructor
    public LibraryUserBean() {
    }

    public LibraryUserBean(int id, String userfirstname, String username, String userpassword, String useremail) {
        this.id = id;
        this.userfirstname = userfirstname;
        this.username = username;
        this.userpassword = userpassword;
        this.useremail = useremail;
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

    // toString

    @Override
    public String toString() {
        return "LibraryUserBean{" +
                "id=" + id +
                ", userfirstname='" + userfirstname + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}
