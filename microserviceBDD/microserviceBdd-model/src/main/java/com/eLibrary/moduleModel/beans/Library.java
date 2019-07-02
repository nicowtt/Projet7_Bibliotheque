package com.eLibrary.moduleModel.beans;


import javax.persistence.*;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.library_id_seq")
    @SequenceGenerator(name = "public.library_id_seq", sequenceName = "public.library_id_seq", allocationSize = 1)
    private int id;
    private String libraryname;

    //contructor
    public Library() {
    }

    public Library(String libraryname) {
        this.libraryname = libraryname;
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibraryname() {
        return libraryname;
    }

    public void setLibraryname(String libraryname) {
        this.libraryname = libraryname;
    }

    //to string
    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", libraryname='" + libraryname + '\'' +
                '}';
    }
}
