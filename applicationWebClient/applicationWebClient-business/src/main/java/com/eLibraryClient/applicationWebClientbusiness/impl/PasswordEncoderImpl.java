package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {

    /**
     * For hashing password
     *
     * @param password_plaintext
     * @return -> hashed password
     */
    @Override
    public String hashPassword(String password_plaintext) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String hashedPassword = passwordEncoder.encode(password_plaintext);
        return hashedPassword;
    }
}
