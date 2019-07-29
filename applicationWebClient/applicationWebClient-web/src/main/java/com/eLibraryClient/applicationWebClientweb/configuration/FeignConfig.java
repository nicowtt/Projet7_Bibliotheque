package com.eLibraryClient.applicationWebClientweb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfig {

    @Bean
    public BasicAuthRequestInterceptor mBasicAuthentificationInterceptor() {
        return new BasicAuthRequestInterceptor("utilisateur", "mdp");
    }
}
