package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.BookReservationManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryUserManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.BookReservationBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

            System.out.println("reservation ok");
            return "home"; //todo faire une page pour comfirmer l'ecriture

        }

    }

}
