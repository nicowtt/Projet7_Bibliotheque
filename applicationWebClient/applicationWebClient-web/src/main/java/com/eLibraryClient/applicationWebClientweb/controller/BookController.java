package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Controller
public class BookController {

//    @Autowired(required = true)
//    private BookManager bookManager;
//
//    @RequestMapping("/home")
//    public String accueil(Model model){
//
//        List<BookBean> books = bookManager.getListAllBooks();
//
//        model.addAttribute("books", books);
//
//        return "Home";
//    }
}
