package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryUserManager;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryUserManagerImpl implements LibraryUserManager {

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    /**
     * ask all user on BDD
     *
     * @return -> list of user
     */
    @Override
    public LibraryUserBean getLibraryUser(String userEmail) {

        LibraryUserBean userBdd = microserviceBDDProxy.getUser(userEmail);

        return userBdd;
    }
}
