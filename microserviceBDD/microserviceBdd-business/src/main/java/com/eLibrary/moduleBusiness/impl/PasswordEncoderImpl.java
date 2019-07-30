package com.eLibrary.moduleBusiness.impl;

import com.eLibrary.moduleBusiness.contract.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {

    /**
     * For check password
     * @param pPasswordPlainText -> pass plain text
     * @param pHashingPassword -> hashingPass
     * @return
     */
    @Override
    public boolean checkPassword(String pPasswordPlainText, String pHashingPassword) {
        boolean pass = false;

        pass = BCrypt.checkpw(pPasswordPlainText,pHashingPassword);
        return pass;
    }
}
