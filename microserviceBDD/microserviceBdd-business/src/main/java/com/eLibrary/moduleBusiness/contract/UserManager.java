package com.eLibrary.moduleBusiness.contract;

import com.eLibrary.moduleModel.beans.Libraryuser;
import org.springframework.stereotype.Service;

@Service
public interface UserManager {
    boolean checkIfMailExist(String mail);
    boolean checkIfUserMailAndPassIsOk(Libraryuser userBean);
}
