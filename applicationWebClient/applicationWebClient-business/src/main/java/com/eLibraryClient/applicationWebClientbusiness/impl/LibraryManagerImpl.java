package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryManager;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryManagerImpl implements LibraryManager {

    @Autowired
    MicroserviceBDDProxy microserviceBDDProxy;

    /**
     * To get one library bean
     * @param libraryName
     * @return
     */
    @Override
    public LibraryBean getOneLibrary(String libraryName) {
        LibraryBean oneLibrary = microserviceBDDProxy.getOneLibrary(libraryName);

        return oneLibrary;
    }
}
