package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleDao.dao.dao.BookDao;
import com.eLibrary.moduleDao.dao.dao.LibraryUserDao;
import com.eLibrary.moduleModel.beans.Book;
import com.eLibrary.moduleModel.beans.BookReservation;
import com.eLibrary.moduleModel.beans.Library;
import com.eLibrary.moduleModel.beans.Libraryuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    @GetMapping(value = "/Books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> booksList() {

        List<Book> booksList = bookDao.findAll();

        return booksList;
    }

    /**
     * Get information about one book
     * @param id -> id of book
     * @return
     */
    @GetMapping(value = "/Book/{id}")
    public Book OneBook(@PathVariable int id) {
        Book oneBook = bookDao.getOne(id);

        return oneBook;
    }

}
