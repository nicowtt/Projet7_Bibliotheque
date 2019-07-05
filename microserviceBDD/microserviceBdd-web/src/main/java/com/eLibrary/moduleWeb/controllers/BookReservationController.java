package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleDao.dao.dao.BookReservationDao;
import com.eLibrary.moduleModel.beans.BookReservation;
import com.eLibrary.moduleModel.beans.Libraryuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookReservationController {

    @Autowired
    private BookReservationDao bookReservationDao;

    /**
     * get list all reservation
     * @return
     */
    @GetMapping(value = "/BookReservation")
    public List<BookReservation> getListReservation() {

        List<BookReservation> bookReservationList = bookReservationDao.findAll();

        return bookReservationList;
    }

    /**
     * Write new reservation
     * @param bookReservation
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/NewBookReservation", consumes="application/json")
    public ResponseEntity<BookReservation> addBookReservation(@RequestBody BookReservation bookReservation) {

        //save newBookReservation
        BookReservation newBookReservation = bookReservationDao.save(bookReservation);

        //send 201 CREATED for confirm new user is saved
        return new ResponseEntity<BookReservation>(newBookReservation, HttpStatus.CREATED);
    }


}
