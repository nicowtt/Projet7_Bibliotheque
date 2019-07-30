package com.eLibraryClient.applicationWebClientbusiness.contract;

import org.springframework.stereotype.Service;

@Service
public interface PasswordEncoder {

    String hashPassword(String password_plaintext);
}
