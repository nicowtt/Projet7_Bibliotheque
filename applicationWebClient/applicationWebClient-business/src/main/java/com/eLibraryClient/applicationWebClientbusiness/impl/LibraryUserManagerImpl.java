package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryUserManager;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryUserManagerImpl implements LibraryUserManager {

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;


    @Override
    public LibraryUserBean checkIfUserIsOnBDD(String userSessionEmail) {

        List<LibraryUserBean> userBddList = new ArrayList<>();
        LibraryUserBean userOnBdd = new LibraryUserBean();

        // get list of all user on bdd
        userBddList = microserviceBDDProxy.getListOfUsers();

        // check if user is on this list
        for (int i = 0; i < userBddList.size(); i++) {
            if (userBddList.get(i).getUseremail().equals(userSessionEmail)) {
                userOnBdd = userBddList.get(i);
            }
        }
        return userOnBdd;
    }
}
