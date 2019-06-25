package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    @RequestMapping("/home")
    public String accueil(Model model){

        List<BookBean> books = microserviceBDDProxy.booksList();

        model.addAttribute("books", books);

        return "Home";
    }
}
