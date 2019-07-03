package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleDao.dao.dao.LibraryUserDao;
import com.eLibrary.moduleModel.beans.Libraryuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    /**
     * write new user
     * @param newUser -> bean new user
     * @return
     */
//    @PostMapping(value = "/NewUser")
//      @PostMapping(value = "/NewUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
      @RequestMapping(method = RequestMethod.POST, value = "/NewUser", consumes="application/json")
      public ResponseEntity<Libraryuser> addUser(@RequestBody Libraryuser newUser) {


        //save newUser
        Libraryuser newUserSave = libraryUserDao.save(newUser);

        //send 201 CREATED for confirm new user is saved
        return new ResponseEntity<Libraryuser>(newUserSave, HttpStatus.CREATED);
    }


}
