package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.springframework.stereotype.Service;

@Service
public interface LibraryUserManager {
    LibraryUserBean checkIfUserIsOnBDD(String userEmail);
    void addNewUserOnBDD(LibraryUserBean LibraryUserBean);
}
