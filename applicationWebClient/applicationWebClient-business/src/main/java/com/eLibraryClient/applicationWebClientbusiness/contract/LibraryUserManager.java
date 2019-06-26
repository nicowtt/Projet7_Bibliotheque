package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.springframework.stereotype.Service;

@Service
public interface LibraryUserManager {
    LibraryUserBean getLibraryUser(String userEmail);
}
