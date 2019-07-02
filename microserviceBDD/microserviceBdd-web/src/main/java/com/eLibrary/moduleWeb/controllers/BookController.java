package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleDao.dao.dao.BookDao;
import com.eLibrary.moduleDao.dao.dao.LibraryUserDao;
import com.eLibrary.moduleModel.beans.Book;
import com.eLibrary.moduleModel.beans.BookReservation;
import com.eLibrary.moduleModel.beans.Library;
import com.eLibrary.moduleModel.beans.Libraryuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    /**
     * Get list of all books from BDD
     *
     * @return
     */
    @GetMapping(value = "/Books")
    public List<Book> booksList() {

        List<Book> booksList = bookDao.findAll();

        return booksList;
    }

//    @GetMapping(value = "/LibraryChoice/{id}")
//    public Libraryuser catalogForOneBook(@PathVariable int id) {
//        //todo 1 method pour avoir une liste de library en fonction de l'id d'un livre
//        Libraryuser catalogListBook = libraryUserDao.listBookAnyLibraries(id);
//
//
//        return catalogListBook;
//    }

}
