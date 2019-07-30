package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryModel.beans.LibraryUserBean;
import org.springframework.stereotype.Service;

@Service
public interface LibraryUserManager {
    LibraryUserBean checkIfUserIsOnBDD(String userEmail);
    boolean addNewUserOnBDD(LibraryUserBean LibraryUserBean);
    LibraryUserBean getOneUser(String userEmail);
    boolean checkIfMailAndPassIsOk(LibraryUserBean user);
}
