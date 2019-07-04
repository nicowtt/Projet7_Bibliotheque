package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;


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
    @GetMapping(value = "/book/{bookId}")
    public String bookReservationLibraryChoice(@PathVariable Integer bookId,
                                               @SessionAttribute(value = "userSession", required = false) LibraryUserBean userSession,
                                               Model model) {

        if (userSession == null) {
            return "errorHtml/errorMissAuth";

        } else {
            BookBean oneBook = bookManager.getOneBook(bookId);
            model.addAttribute("book", oneBook);
            model.addAttribute("log", userSession);

            return "reservationLibraryChoiceOneBook";
        }





    }

//    @GetMapping(value = "/bookReservation/{bookId}/{bookLibraryId")
//    public String bookReservation(@PathVariable Integer bookId, @PathVariable Integer bookLibraryId,
//                                  @SessionAttribute(value = "userSession", required = false) LibraryUserBean userSession,
//                                  Model model) {
//
//        //todo 4 envoi le bean non rempli a la couche business
//        // j'envoi a la couche business le bean BookReservationBean avec l'userId, bookId et libraryId.
//        // je finirais de remplir le bean dans la couche business (manque la date du jour, la date de retour et l'extension)
//        // et je retourne la page qui dit reservation ok
//
//        return "home"; //todo 6 ici aussi il faudra crée une nouvelle page de confirmation d'ecriture
//
//    }


}
