package com.eLibraryClient.applicationWebClientweb.controller;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryCatalogManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryManager;
import com.eLibraryModel.beans.BookBean;
import com.eLibraryModel.beans.LibraryBean;
import com.eLibraryModel.beans.LibraryCatalogBean;
import com.eLibraryModel.beans.LibraryUserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SearchController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookManager bookManager;
    @Autowired
    LibraryManager libraryManager;
    @Autowired
    LibraryCatalogManager libraryCatalogManager;

    /**
     * For display filters (by library or/and by book label)
     * @param userSession
     * @param model
     * @return
     */
    @GetMapping(value = "/Search")
    public String search(@SessionAttribute(value = "userSession", required = false)LibraryUserBean userSession,
                         Model model) {
        BookBean newBook = new BookBean();
        List<LibraryBean> allLibrariesList = libraryManager.getAllLibraries();
        List<BookBean> books = bookManager.getListAllBooks();
        //todo ->amélioration faire une methode pour avoir une liste de bookBean sans repetition (label) à checker

        model.addAttribute("libraries", allLibrariesList);
        model.addAttribute("library", new LibraryBean());
        model.addAttribute("books", books);
        model.addAttribute("book", newBook);
        if (userSession != null) {
            model.addAttribute("log", userSession);
        }
        return "/Search";
    }

    /**
     * For display books with filter (library name and book label(ex:fantastique))
     * @param libraryBean
     * @param bookBean
     * @param userSession
     * @param model
     * @return
     */
    @PostMapping(value = "/SearchPost")
    public String searchPost(@Valid @ModelAttribute("library") LibraryBean libraryBean,
                             @Valid @ModelAttribute("book") BookBean bookBean,
                             @SessionAttribute(value = "userSession", required = false)LibraryUserBean userSession,
                             Model model) {
        List<LibraryCatalogBean> LibraryCatalogListWithFilter = libraryCatalogManager.getListOfLibraryCatalogWithLibraryNameAndBookLabelFilter(libraryBean.getLibraryname(), bookBean.getBooklabel());

        model.addAttribute("libraryCatalog", LibraryCatalogListWithFilter);
        model.addAttribute("log", userSession);

        return "/resultOfSearch";

    }
}
