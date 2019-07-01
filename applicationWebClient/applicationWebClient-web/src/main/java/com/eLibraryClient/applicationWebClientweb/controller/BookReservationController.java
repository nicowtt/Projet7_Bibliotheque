package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class BookReservationController {

    @GetMapping(value = "/bookLibrary/{bookId}")
    public String bookReservationLibraryChoice(@PathVariable Integer bookId,
                                               @SessionAttribute(value = "userSession") LibraryUserBean userSession,
                                               Model model) {

        //todo 1 envoi le bookId a la couche business
        // j'envoi a la couche business l'id du book afin de checker en BDD dans quelle library il
        // se trouve à l'instant T
        // et ensuite J'affiche les beans possible du bouquin (afin que l'utilisateur choisisse la bibliotheque)


        return "home"; //todo 3 il faut crée une nouvelle page

    }

    @GetMapping(value = "/bookReservation/{bookId}/{bookLibraryId")
    public String bookReservation(@PathVariable Integer bookId, @PathVariable Integer bookLibraryId,
                                  @SessionAttribute(value = "userSession", required = false) LibraryUserBean userSession,
                                  Model model) {

        //todo 4 envoi le bean non rempli a la couche business
        // j'envoi a la couche business le bean BookReservationBean avec l'userId, bookId et libraryId.
        // je finirais de remplir le bean dans la couche business (manque la date du jour, la date de retour et l'extension)
        // et je retourne la page qui dit reservation ok

        return "home"; //todo 6 ici aussi il faudra crée une nouvelle page de confirmation d'ecriture

    }


}
