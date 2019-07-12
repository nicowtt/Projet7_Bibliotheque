package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookReservationManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryCatalogManager;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryCatalogBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.util.ArrayList;
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

    /**
     * get list of books with library name and book label filter (multi criteria)
     * @param libraryName
     * @param bookLabel
     * @return
     */
    @Override
    public List<LibraryCatalogBean> getListOfLibraryCatalogWithLibraryNameAndBookLabelFilter(String libraryName, String bookLabel) {

        List<LibraryCatalogBean> libraryCatalogListWithFilters = new ArrayList<>();
        List<LibraryCatalogBean> libraryCatalogBeans = microserviceBDDProxy.getLibrariesCatalog();

        // filter
        if (libraryName.equals("") && bookLabel.equals("")) { // no filter asking by user
        } else {

            // only library filter
            if (bookLabel.equals("")) {
                // pour chaque bean si la library est pareil
                for (int i = 0; i < libraryCatalogBeans.size(); i++) {
                    if (libraryCatalogBeans.get(i).getLibrary().getLibraryname().equals(libraryName)) {
                        libraryCatalogListWithFilters.add(libraryCatalogBeans.get(i));
                    }
                }
            }
            // only book label filter
            else if (libraryName.equals("")) {
                for (int i = 0; i < libraryCatalogBeans.size(); i++) {
                    if (libraryCatalogBeans.get(i).getBook().getBooklabel().equals(bookLabel)) {
                        libraryCatalogListWithFilters.add(libraryCatalogBeans.get(i));
                    }
                }

                //for delete book repetition
                String bookName = "";
                int count = 0;
                List<LibraryCatalogBean> listWithoutDouble = new ArrayList<>();
                listWithoutDouble = libraryCatalogListWithFilters;

                for (int i = 0; i < libraryCatalogListWithFilters.size(); i++) {
                    bookName = libraryCatalogListWithFilters.get(i).getBook().getBookname();
                    for (int j = 0; j < listWithoutDouble.size(); j++) {
                        if (listWithoutDouble.get(j).getBook().getBookname() == bookName) {
                            count++;
                            if (count > 1) {listWithoutDouble.remove(j);}
                        }
                    }
                }
            }

            // library name and book label
            else {
                for (int i = 0; i < libraryCatalogBeans.size(); i++) {
                    if (libraryCatalogBeans.get(i).getBook().getBooklabel().equals(bookLabel) &&
                            libraryCatalogBeans.get(i).getLibrary().getLibraryname().equals(libraryName) ) {
                        libraryCatalogListWithFilters.add(libraryCatalogBeans.get(i));
                    }
                }
            }
        }
        return libraryCatalogListWithFilters;
    }
}


