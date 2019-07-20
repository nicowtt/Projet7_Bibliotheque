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
     * When user choose a book
     * -> need choose library to reserve this book
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
            List<LibraryCatalogBean> libraryCatalogOnOneBookList = libraryCatalogManager.getLibrariesCatalogForOneBook(bookId);
            List<LibraryCatalogBean> refineLibraryCatalogOnOneBookList =
                    libraryCatalogManager.refineDisponibilityWithBookReservationInProgress(bookId, libraryCatalogOnOneBookList );

            model.addAttribute("books", refineLibraryCatalogOnOneBookList);
            model.addAttribute("book", new BookBean());
            model.addAttribute("log", userSession);
        } else {
            return "errorHtml/errorMissAuth";
        }

        return "reservationLibraryChoiceOneBook";

    }

    /**
     * For create a book reservation
     * @param bookId
     * @param userSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/bookReservation/{bookId}/{libraryId}", method = RequestMethod.GET)
    public String bookReservation(@PathVariable Integer bookId,@PathVariable Integer libraryId,
                                  @SessionAttribute(value = "userSession", required = false) LibraryUserBean userSession,
                                  Model model) {
        BookReservationBean newBookReservation = new BookReservationBean();

        LibraryUserBean beanUserOnSession = libraryUserManager.getOneUser(userSession.getUseremail());
        newBookReservation.setBookId(bookId);
        newBookReservation.setUserId(beanUserOnSession.getId());
        newBookReservation.setLibraryId(libraryId);
        bookReservationManager.completeWithDate(newBookReservation);
        logger.info("nouvelle reservation sur livre d'ID: " + bookId + " dans la bibliotheque d'Id " + libraryId);
        bookManager.changeDisponibilityForOneBook(bookId);

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
        LibraryUserBean beanUserOnSession = libraryUserManager.getOneUser(userSession.getUseremail());
        List<BookReservationBean> bookReservationListForOneUser = bookReservationManager.bookReservationListForOneUser(beanUserOnSession.getId());

        BookReservationBean bookReservationBeanToUpdate = bookReservationManager.getOneBookReservation(reservationId);
        String extendDate = dateManager.addDaysOnOneDate(bookReservationBeanToUpdate.getEndOfReservationDate(), 28);
        bookReservationBeanToUpdate.setExtensionOfReservation(true);
        bookReservationBeanToUpdate.setEndOfReservationDate(extendDate);
        bookReservationManager.updateBookReservation(bookReservationBeanToUpdate);

        model.addAttribute("reservation", bookReservationListForOneUser);
        model.addAttribute("log", userSession);

        logger.info("L'utilisateur " + beanUserOnSession.getUseremail() + " à prolongé la reservation du livre:"
        + bookReservationBeanToUpdate.getBook().getBookname() + " dans la bibliothèque:"
        + bookReservationBeanToUpdate.getLibrary().getLibraryname() + ".");

        return "/PersonalSpace";
    }

    /**
     * For book bring back
     * @param reservationId
     * @param userSession
     * @param model
     * @return
     */
    @RequestMapping(value = "/BookBack/{reservationId}", method = RequestMethod.GET)
    public String bookBack(@PathVariable Integer reservationId,
                           @SessionAttribute(value = "userSession", required = false)LibraryUserBean userSession,
                           Model model) {
        BookReservationBean bookReservationBeanToUpdate = bookReservationManager.getOneBookReservation(reservationId);

        bookReservationManager.bookBack(reservationId);
        bookManager.changeDisponibilityForOneBook(bookReservationBeanToUpdate.getBook().getId());

        model.addAttribute("log", userSession);

        logger.info("L'utilisateur " + userSession.getUseremail() + " a rendu le livre de la reservation d'id: " + reservationId);

        return "/Confirmationhtml/bookBackOk";
    }


}
