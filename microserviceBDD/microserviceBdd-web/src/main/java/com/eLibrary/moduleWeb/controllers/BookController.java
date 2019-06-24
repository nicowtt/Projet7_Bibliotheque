package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleDao.dao.dao.BookDao;
import com.eLibrary.moduleModel.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @GetMapping(value = "/Books")
    public List<Book> booksList() {

        List<Book> booksList = bookDao.findAll();

        return booksList;
    }
}
