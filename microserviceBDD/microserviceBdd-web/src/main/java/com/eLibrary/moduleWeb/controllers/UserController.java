package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleBusiness.contract.UserManager;
import com.eLibrary.moduleDao.dao.LibraryUserDao;
import com.eLibrary.moduleModel.beans.LibraryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private LibraryUserDao libraryUserDao;

    @Autowired
    private UserManager userManager;

    /**
     * get list of all users from BDD
     *
     * @return
     */
    @GetMapping(value = "/Users")
    public List<LibraryUser> getUsers() {

        List<LibraryUser> usersList = libraryUserDao.findAll();
        return usersList;
    }

    /**
     * get one user
     * @param email
     * @return
     */
    @GetMapping(value = "/User/{email}")
    public LibraryUser getOneUser(@PathVariable String email) {

        LibraryUser oneUser = libraryUserDao.findByUseremail(email);
        return oneUser;
    }

    /**
     * write new user
     * @param newUser -> bean new user
     * @return
     */
      @RequestMapping(method = RequestMethod.POST, value = "/NewUser", consumes="application/json")
      public ResponseEntity<LibraryUser> addUser(@RequestBody LibraryUser newUser) {
          LibraryUser newUserWrited;

          newUserWrited = userManager.addNewUser(newUser);
          //send 201 and newUserWrited CREATED for confirm new user is saved
        return new ResponseEntity<LibraryUser>(newUserWrited, HttpStatus.CREATED);
    }

    /**
     * To check if user mail and password is ok
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/CheckUser", consumes = "application/json")
    public boolean checkUser(@RequestBody LibraryUser user) {
          boolean userIsValid = false;

        userIsValid = userManager.checkIfUserMailAndPassIsOk(user);
          return userIsValid;
    }


}
