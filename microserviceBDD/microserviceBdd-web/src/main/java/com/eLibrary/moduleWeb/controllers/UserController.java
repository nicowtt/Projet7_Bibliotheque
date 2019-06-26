package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleDao.dao.dao.LibraryUserDao;
import com.eLibrary.moduleModel.beans.Libraryuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private LibraryUserDao libraryUserDao;

    /**
     * get list of all users from BDD
     *
     * @return
     */
    @GetMapping(value = "/Users")
    public List<Libraryuser> getUsers() {

        List<Libraryuser> usersList = libraryUserDao.findAll();

        return usersList;
    }
}
