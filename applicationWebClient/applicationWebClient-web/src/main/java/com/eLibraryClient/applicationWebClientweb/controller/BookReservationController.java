package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.BookReservationBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
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
            // need user_id
            //todo 2 chercher l'user-id avec l'email
            // need library_id
            //todo 3 chercher la libray_id avec le nom de la library
            //todo 4 envoi le bean non rempli a la couche business

        }




        // j'envoi a la couche business le bean BookReservationBean avec l'userId, bookId et libraryId.
        // je finirais de remplir le bean dans la couche business (manque la date du jour, la date de retour et l'extension)
        // et je retourne la page qui dit reservation ok

        return "home"; //todo 6 ici aussi il faudra crée une nouvelle page de confirmation d'ecriture

    }


}
