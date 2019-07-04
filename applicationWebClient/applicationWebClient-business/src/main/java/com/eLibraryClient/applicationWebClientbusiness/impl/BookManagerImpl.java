package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookManagerImpl implements BookManager {

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    static final Log logger = LogFactory.getLog(BookManagerImpl.class);

    /**
     * Ask all books from BDD
     *
     * @return -> list of all books
     */
    @Override
    public List<BookBean> getListAllBooks() {

        List<BookBean> booksList = microserviceBDDProxy.getBooksList();

        return booksList;
    }

    /**
     * Ask one book from BDD
     * @param pBookId
     * @return
     */
    @Override
    public BookBean getOneBook(int pBookId) {
        BookBean oneBook = microserviceBDDProxy.getOneBook(pBookId);
        return oneBook;
    }


}
