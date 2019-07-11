package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.*;
import com.eLibraryClient.applicationWebClientmodel.beans.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;

import java.util.List;


@Controller
public class BookReservationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookManager bookManager;

    @Autowired
    private LibraryUserManager libraryUserManager;

    @Autowired
    private DateManager dateManager;

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


        if (userSession != null) {
            // get library list for this book
            List<LibraryCatalogBean> libraryCatalogOnOneBookList = libraryCatalogManager.getLibrariesCatalogForOneBook(bookId);

            // refine book disponibility according to book reservation in progress
            List<LibraryCatalogBean> affinedLibraryCatalogOnOneBookList = libraryCatalogManager.refineDisponibilityWithBookReservationInProgress(bookId, libraryCatalogOnOneBookList );

            //display model
            model.addAttribute("books", affinedLibraryCatalogOnOneBookList);
            model.addAttribute("book", new BookBean());
            model.addAttribute("log", userSession);
        } else {
            return "errorHtml/errorMissAuth";
        }

        return "reservationLibraryChoiceOneBook";

    }

    /**
     * For create a book reservation
     * @param bookId -> bookid to reserve
     * @param userSession -> user id to reserve
     * @param model -> model
     * @return
     */
    @RequestMapping(value = "/bookReservation/{bookId}/{libraryId}", method = RequestMethod.GET)
    public String bookReservation(@PathVariable Integer bookId,@PathVariable Integer libraryId,
                                  @SessionAttribute(value = "userSession", required = false) LibraryUserBean userSession,
                                  Model model) {

        BookReservationBean newBookReservation = new BookReservationBean();

        //get userId
        LibraryUserBean userOnSession = libraryUserManager.getOneUser(userSession.getUseremail());
        //set newBookReservation
        newBookReservation.setBookId(bookId);
        newBookReservation.setUserId(userOnSession.getId());
        newBookReservation.setLibraryId(libraryId);

        //send for complete date of reservation and write on bdd
        bookReservationManager.completeWithDate(newBookReservation);
        logger.info("nouvelle reservation sur livre d'ID: " + bookId + " dans la bibliotheque d'Id " + libraryId);

        // change disponibility of book to false if all iteration of this book is reserved
        bookManager.changedisponibilityOfOneBookIfNeeded(bookId);

        //model for log
        model.addAttribute("log", userSession);

        return "/confirmationhtml/bookReservationOk";
    }

    /**
     * For extend book back end time (only one time)
     * @param reservationId
     * @param userSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/ExtendTime/{reservationId}", method = RequestMethod.GET)
    public String extendReservationTime(@PathVariable Integer reservationId,
                                        @SessionAttribute(value = "userSession", required = false) LibraryUserBean userSession,
                                        Model model) {

        // get book reservation bean in BDD
        BookReservationBean bookReservationBeanToUpdate = bookReservationManager.getOneBookReservation(reservationId);
        // get end date of reservation and add 28 days (4 weeks)
        String extendDate = dateManager.addDaysOnOneDate(bookReservationBeanToUpdate.getEndOfReservationDate(), 28);
        // change boolean extensionofreservation to true -> user can extend date only one time
        bookReservationBeanToUpdate.setExtensionOfReservation(true);
        // set new end date on bean
        bookReservationBeanToUpdate.setEndOfReservationDate(extendDate);
        // send to microserviceBdd to update this reservation
        bookReservationManager.updateBookReservation(bookReservationBeanToUpdate);

        //for display updated personalSpace
        //get full bean userOnSession
        LibraryUserBean userOnSession = libraryUserManager.getOneUser(userSession.getUseremail());
        //get list of reservation for this user
        List<BookReservationBean> bookReservationListForOneUser = bookReservationManager.bookReservationListForOneUser(userOnSession.getId());
        // model for display
        model.addAttribute("reservation", bookReservationListForOneUser);
        model.addAttribute("log", userSession);

        logger.info("L'utilisateur " + userOnSession.getUseremail() + " à prolongé la reservation du livre:"
        + bookReservationBeanToUpdate.getBook().getBookname() + " dans la bibliothèque:"
        + bookReservationBeanToUpdate.getLibrary().getLibraryname() + ".");

        return "/PersonalSpace";
    }


}
