package com.eLibrary.moduleWeb.controllers;

import com.eLibrary.moduleDao.dao.dao.LibraryDao;
import com.eLibrary.moduleModel.beans.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryDao libraryDao;

    /**
     * Get list of all libraries
     * @return
     */
    @GetMapping(value = "/Libraries" )
    public List<Library> getLibraryList() {

        List<Library> librariesList = libraryDao.findAll();

        return librariesList;
    }
}
