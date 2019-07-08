package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.*;
import com.eLibraryClient.applicationWebClientmodel.beans.*;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BookReservationController {

    @Autowired
    private BookManager bookManager;

    @Autowired
    private LibraryUserManager libraryUserManager;

    @Autowired
    private LibraryManager libraryManager;

    @Autowired
    private BookReservationManager bookReservationManager;

    @Autowired
    private LibraryCatalogManager libraryCatalogManager;



    /**
     * User choose library to reserve one book
     * @param bookId
     * @param userSession
     * @param model
     * @return -> choose page
     */
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public String bookReservationLibraryChoice(@PathVariable Integer bookId,
                                               @SessionAttribute(value = "userSession", required = false) LibraryUserBean userSession,
                                               Model model) {

        if (userSession == null) {
            return "errorHtml/errorMissAuth";

        } else {
            BookBean book = bookManager.getOneBook(bookId);
            model.addAttribute("book", book);
            model.addAttribute("log", userSession);

            return "reservationLibraryChoiceOneBook";
        }
    }

    /**
     * For create a book reservation
     * @param newbook -> bean for libraryChoice input
     * @param bindingResult -> list of form error
     * @param bookId -> bookid to reserve
     * @param userSession -> user id to reserve
     * @param model -> model
     * @return
     */
    @RequestMapping(value = "/bookReservation/{bookId}", method = RequestMethod.POST)
    public String bookReservation(@Valid @ModelAttribute("book") BookBean newbook, BindingResult bindingResult,
                                  @PathVariable Integer bookId,
                                  @SessionAttribute(value = "userSession", required = false) LibraryUserBean userSession,
                                  Model model) {

        BookReservationBean newBookReservation = new BookReservationBean();

        if (bindingResult.hasErrors()) {
            model.addAttribute("book", newbook);
            System.out.println("error");
        } else {
            //set book to reserve
            newBookReservation.setBook_id(bookId);
            // set user_id
            LibraryUserBean userOnSession = libraryUserManager.getOneUser(userSession.getUseremail());
            newBookReservation.setUser_id(userOnSession.getId());
            // need library_id
            LibraryBean libraryForreservation = libraryManager.getOneLibrary(newbook.getReservationlibrary());
            newBookReservation.setLibrary_id(libraryForreservation.getId());

            //send for complete date of reservation and write on bdd
            bookReservationManager.completeWithDate(newBookReservation);

            //update if needed disponibility of book ->>

            //get iteration number of book on all city
            int nbrIterationBook = bookManager.getNbrOfIterationForOneBook(newBookReservation.getBook_id());
            //get count number of reservation for one book in progress
            int countReservationForOneBookInProgress = bookReservationManager.countReservationInProgressForOneBook(newBookReservation.getBook_id());
            // change disponibility of book to false if needed
            bookManager.checkForChangedisponibility(countReservationForOneBookInProgress, nbrIterationBook);

            //model for log
            model.addAttribute("log", userSession);
        }
        return "/confirmationhtml/bookReservationOk";
    }

}
