package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryUserManager {
    LibraryUser getLibraryUser(String userEmail);
}
