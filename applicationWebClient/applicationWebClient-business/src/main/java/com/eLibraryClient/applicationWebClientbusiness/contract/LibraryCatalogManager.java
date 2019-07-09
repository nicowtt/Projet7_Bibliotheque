package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientmodel.beans.LibraryCatalogBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryCatalogManager {

    List<LibraryCatalogBean> getLibrariesCatalog();
    List<LibraryCatalogBean> getLibrariesCatalogForOneBook(int bookId);
    List<LibraryCatalogBean> refineDisponibilityWithBookReservationInProgress(int bookId, List<LibraryCatalogBean> libraryCatalogBeanList);
}
