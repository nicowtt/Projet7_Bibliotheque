package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

@Component
public class BookManagerImpl {

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    static final Log logger = LogFactory.getLog(BookManagerImpl.class);

    public List<BookBean> getListAllBooks() {

        List<BookBean> booksList = microserviceBDDProxy.booksList();

        return booksList;
    }


}
