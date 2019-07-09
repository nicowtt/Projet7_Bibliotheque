package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.*;
import com.eLibraryClient.applicationWebClientmodel.beans.*;
import org.apache.tomcat.jni.Library;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BookReservationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

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
        int correctionDisponibility = 0;
        int reservationInProgress = 0;
        int result = 0;


        if (userSession != null) {
            // je vais chercher la liste des library qui ont ce livre
            List<LibraryCatalogBean> libraryCatalogIOneBookList = libraryCatalogManager.getLibrariesCatalogForOneBook(bookId);

            // dans cette liste de library je vais verifier si il y a en cours des reservation sur le livre
            // afin d'affiner la disponibiliter
            for (int i = 0; i < libraryCatalogIOneBookList.size(); i++) {
                reservationInProgress = bookReservationManager.nbrBookReservationInProgressForOneLibraryAndOneBookList(libraryCatalogIOneBookList.get(i).getLibrary().getId(), bookId);

                int iterationOfBook = libraryCatalogIOneBookList.get(i).getId().getBookIteration();
                result = iterationOfBook - reservationInProgress;
                libraryCatalogIOneBookList.get(i).getId().setBookIteration(result);
                logger.info("correction d'iteration disponible: " + iterationOfBook + " - " + reservationInProgress + "=" + result + " sur la bibliotheque: " + libraryCatalogIOneBookList.get(i).getLibrary().getLibraryname());
            }
            model.addAttribute("books", libraryCatalogIOneBookList);
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

        //set book to reserve
        newBookReservation.setBook_id(bookId);
        // set user_id
        LibraryUserBean userOnSession = libraryUserManager.getOneUser(userSession.getUseremail());
        newBookReservation.setUser_id(userOnSession.getId());
        // need library_id
//            LibraryBean libraryForreservation = libraryManager.getOneLibrary(newbook.getReservationlibrary());
        newBookReservation.setLibrary_id(libraryId);

        //send for complete date of reservation and write on bdd
        bookReservationManager.completeWithDate(newBookReservation);
        logger.info("nouvelle reservation sur livre d'ID: " + bookId + " dans la bibliotheque d'Id " + libraryId);

        //update if needed disponibility of book ->>

        //get iteration number of book on all city
        int nbrIterationBook = bookManager.getNbrOfIterationForOneBook(newBookReservation.getBook_id());
        //get count number of reservation for one book in progress
        int countReservationForOneBookInProgress = bookReservationManager.countReservationInProgressForOneBook(newBookReservation.getBook_id());
        // change disponibility of book to false if needed
        bookManager.changedisponibilityOfOneBookIfNeeded(countReservationForOneBookInProgress, nbrIterationBook, newBookReservation.getBook_id());

        //model for log
        model.addAttribute("log", userSession);

        return "/confirmationhtml/bookReservationOk";
    }

}
