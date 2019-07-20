package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryUserManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.PasswordEncoder;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.slf4j.LoggerFactory;
import java.util.List;

@Controller
@SessionAttributes("userSession")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LibraryUserManager libraryUserManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private BookManager bookManager;

    @ModelAttribute("userSession")
    public LibraryUserBean setUpUserForm() {
        return new LibraryUserBean();
    }

    /**
     * For user login
     *
     * @param userSession -> user on session
     * @param request
     * @param status
     * @param model -> model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("userSession")LibraryUserBean userSession, WebRequest request, SessionStatus status, Model model) {
        boolean checkPassword = false;
        LibraryUserBean beanUserIsOnBdd = new LibraryUserBean();
        List<BookBean> listBooks = bookManager.getListAllBooks();

        beanUserIsOnBdd.setUseremail(userSession.getUseremail());
        beanUserIsOnBdd = libraryUserManager.checkIfUserIsOnBDD(userSession.getUseremail());
        checkPassword = passwordEncoder.checkPassword(userSession.getUserpassword(), beanUserIsOnBdd.getUserpassword());

        if (checkPassword) {
            model.addAttribute("log", userSession);
        } else {
            status.setComplete();
            request.removeAttribute("userSession", WebRequest.SCOPE_SESSION);
            return "errorHtml/errorLogin";
        }

        model.addAttribute("books", listBooks);
        logger.info(userSession.getUseremail() + " est en session");
        return "home";
    }

    /**
     * for user logout
     *
     * @param userSession
     * @param webRequest
     * @param sessionStatus
     * @param model
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String doLogout(@SessionAttribute(value = "userSession")LibraryUserBean userSession,
                           WebRequest webRequest, SessionStatus sessionStatus, Model model) {
        List<BookBean> books = bookManager.getListAllBooks();

        sessionStatus.setComplete();
        webRequest.removeAttribute("userSession", WebRequest.SCOPE_SESSION);

        model.addAttribute("books", books);
        logger.info(userSession.getUseremail() + " est déconnecté");
        return "home";
    }




}
