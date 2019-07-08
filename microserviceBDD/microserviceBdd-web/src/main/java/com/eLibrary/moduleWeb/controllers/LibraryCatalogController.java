package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleDao.dao.dao.LibraryCatalogDao;
import com.eLibrary.moduleModel.beans.LibraryCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryCatalogController {

    @Autowired
    private LibraryCatalogDao libraryCatalogDao;

    @GetMapping(value = "/LibrariesCatalog")
    public List<LibraryCatalog> getLibrariesCatalog() {
        List<LibraryCatalog> librariescatalogList = libraryCatalogDao.findAll();

        return librariescatalogList;
    }
}
