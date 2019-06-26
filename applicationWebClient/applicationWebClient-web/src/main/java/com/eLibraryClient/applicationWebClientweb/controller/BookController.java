package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookManager bookManager;

    /**
     * For display home page
     *
     * @param model -> model
     * @return home.html
     */
    @RequestMapping("/home")
    public String accueil(Model model, @SessionAttribute(value = "LibraryUser", required = false)LibraryUser libraryUserSession){

        List<BookBean> books = bookManager.getListAllBooks();

        model.addAttribute("books", books);

        //model for "library user session"
        if (libraryUserSession != null) {
            model.addAttribute("userSession", libraryUserSession.getUseremail());
        }

        return "Home";
    }
}
