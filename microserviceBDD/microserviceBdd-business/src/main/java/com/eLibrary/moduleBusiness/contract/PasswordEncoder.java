package com.eLibrary.moduleBusiness.contract;

import org.springframework.stereotype.Service;

@Service
public interface PasswordEncoder {
    boolean checkPassword(String pPasswordPlainText, String pHashingPassword);
}
