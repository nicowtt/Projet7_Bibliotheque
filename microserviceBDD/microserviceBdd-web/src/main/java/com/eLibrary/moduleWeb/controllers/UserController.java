package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleBusiness.contract.UserManager;
import com.eLibrary.moduleDao.dao.LibraryUserDao;
import com.eLibrary.moduleModel.beans.Libraryuser;
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
    public List<Libraryuser> getUsers() {

        List<Libraryuser> usersList = libraryUserDao.findAll();

        return usersList;
    }

    /**
     * get one user
     * @param email
     * @return
     */
    @GetMapping(value = "/User/{email}")
    public Libraryuser getOneUser(@PathVariable String email) {

        Libraryuser oneUser = libraryUserDao.findByUseremail(email);

        return oneUser;
    }

    /**
     * write new user
     * @param newUser -> bean new user
     * @return
     */
      @RequestMapping(method = RequestMethod.POST, value = "/NewUser", consumes="application/json")
      public boolean addUser(@RequestBody Libraryuser newUser) {
          boolean mailAlreadyExist = false;
          mailAlreadyExist = userManager.addNewUser(newUser);
          return mailAlreadyExist;
    }

    /**
     * To check if user mail and password is ok
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/CheckUser", consumes = "application/json")
    public boolean checkUser(@RequestBody Libraryuser user) {
          boolean userIsValid = false;

        userIsValid = userManager.checkIfUserMailAndPassIsOk(user);
          return userIsValid;

    }


}
