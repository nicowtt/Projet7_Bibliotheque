package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.slf4j.LoggerFactory;
import java.util.List;

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookManager bookManager;

    /**
     * For display home page
     *
     * @param model
     * @return
     */
    @RequestMapping("/home")
    public String accueil(Model model, @SessionAttribute(value = "userSession", required = false)LibraryUserBean userSession){

        List<BookBean> books = bookManager.getListAllBooks();

        model.addAttribute("books", books);
        //for display user on session
        if (userSession != null) {
            model.addAttribute("log", userSession);
        }

        return "home";
    }
}
