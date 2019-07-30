package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.LibraryUserManager;
import com.eLibraryModel.beans.LibraryUserBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryUserManagerImpl implements LibraryUserManager {

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    /**
     * For check if user is present on BDD
     * @param userSessionEmail
     * @return
     */
    @Override
    public LibraryUserBean checkIfUserIsOnBDD(String userSessionEmail) {
        List<LibraryUserBean> userBddList = new ArrayList<>();
        LibraryUserBean beanUserOnBdd = new LibraryUserBean();
        userBddList = microserviceBDDProxy.getListOfUsers();

        for (int i = 0; i < userBddList.size(); i++) {
            if (userBddList.get(i).getUseremail().equals(userSessionEmail)) {
                beanUserOnBdd = userBddList.get(i);
            }
        }
        return beanUserOnBdd;
    }


    /**
     * For add new user on microservice BDD
     * @param libraryUserBean
     */
    @Override
    public boolean addNewUserOnBDD(LibraryUserBean libraryUserBean) {
        boolean mailAlreadyExist = false;
        mailAlreadyExist= microserviceBDDProxy.addUser(libraryUserBean);

        return mailAlreadyExist;
    }

    /**
     * get bean with one user mail
     * @param userEmail
     * @return
     */
    @Override
    public LibraryUserBean getOneUser(String userEmail) {
        LibraryUserBean getOneUser = microserviceBDDProxy.getOneUser(userEmail);
        return getOneUser;
    }

    /**
     * To check is user mail and password exist on microserviceBDD
     * @param userBean
     * @return
     */
    @Override
    public boolean checkIfMailAndPassIsOk(LibraryUserBean userBean) {
        Boolean isValid = false;
        isValid = microserviceBDDProxy.checkUser(userBean);
        return  isValid;
    }
}
