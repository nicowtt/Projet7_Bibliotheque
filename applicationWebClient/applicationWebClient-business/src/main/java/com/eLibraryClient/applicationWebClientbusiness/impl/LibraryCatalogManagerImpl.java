package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryCatalogManager;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryCatalogBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryCatalogManagerImpl implements LibraryCatalogManager {

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    /**
     * get libraries Catalog for all book
     * @return
     */
    @Override
    public List<LibraryCatalogBean> getLibrariesCatalog() {

        List<LibraryCatalogBean> librariesCatalogList = microserviceBDDProxy.getLibrariesCatalog();

        return librariesCatalogList;
    }

    /**
     * Get libraries Catalog for one book
     * @param
     * @return
     */
    @Override
    public List<LibraryCatalogBean> getLibrariesCatalogForOneBook(int bookId) {

        List<LibraryCatalogBean> librariescatalogForOneBook = microserviceBDDProxy.getLibrariesCatalogForOneBook(bookId);

        return librariescatalogForOneBook;
    }
}


