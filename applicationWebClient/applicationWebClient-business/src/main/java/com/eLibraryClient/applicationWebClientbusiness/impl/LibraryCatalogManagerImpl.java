package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookReservationManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryCatalogManager;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryCatalogBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.util.List;

@Component
public class LibraryCatalogManagerImpl implements LibraryCatalogManager {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    @Autowired
    private BookReservationManager bookReservationManager;

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

    /**
     * For refine Disponibility with book reservation in progress
     * @param bookId
     * @param libraryCatalogIOneBookList
     * @return
     */
    @Override
    public List<LibraryCatalogBean> refineDisponibilityWithBookReservationInProgress(int bookId, List<LibraryCatalogBean> libraryCatalogIOneBookList) {

        int reservationInProgress = 0;
        int result = 0;

        for (int i = 0; i < libraryCatalogIOneBookList.size(); i++) {
            reservationInProgress = bookReservationManager.nbrBookReservationInProgressForOneLibraryAndOneBookList(libraryCatalogIOneBookList.get(i).getLibrary().getId(), bookId);

            int iterationOfBook = libraryCatalogIOneBookList.get(i).getId().getBookIteration();
            result = iterationOfBook - reservationInProgress;
            libraryCatalogIOneBookList.get(i).getId().setBookIteration(result);

            logger.info("iteration du livre pour la bibliotheque: " + libraryCatalogIOneBookList.get(i).getLibrary().getLibraryname() + "-> " + iterationOfBook);
            logger.info("Reservation en cours: " + reservationInProgress);
            logger.info("Nouvelle disponibilité :" + result);
            logger.info("************************************************");

        }
        return libraryCatalogIOneBookList;
    }
}


