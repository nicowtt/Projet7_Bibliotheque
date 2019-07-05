package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientmodel.beans.LibraryBean;
import org.springframework.stereotype.Service;

@Service
public interface LibraryManager {
    LibraryBean getOneLibrary(String libraryName);
}
