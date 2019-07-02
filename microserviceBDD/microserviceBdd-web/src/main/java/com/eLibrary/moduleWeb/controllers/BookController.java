package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleDao.dao.dao.BookDao;
import com.eLibrary.moduleDao.dao.dao.LibraryDao;
import com.eLibrary.moduleModel.beans.Book;
import com.eLibrary.moduleModel.beans.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private LibraryDao libraryDao;

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

    @GetMapping(value = "/LibraryChoice/{id}")
    public List<Library> oneBook(@PathVariable int id) {
        List <Library> libraryList = libraryDao.findAll();


        return libraryList;
    }

}
