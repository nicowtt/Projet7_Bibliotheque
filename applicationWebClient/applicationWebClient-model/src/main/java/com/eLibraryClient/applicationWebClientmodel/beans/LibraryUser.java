package com.eLibraryClient.applicationWebClientmodel.beans;

public class LibraryUser {

    private int id;
    private String userfirstname;
    private String username;
    private String userpassword;
    private String useremail;

    // Constructor
    public LibraryUser() {
    }

    public LibraryUser(int id, String userfirstname, String username, String userpassword, String useremail) {
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
        return "LibraryUser{" +
                "id=" + id +
                ", userfirstname='" + userfirstname + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}
