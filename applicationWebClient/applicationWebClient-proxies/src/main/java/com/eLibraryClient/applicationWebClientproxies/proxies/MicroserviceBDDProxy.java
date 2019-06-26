package com.eLibraryClient.applicationWebClientproxies.proxies;


import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "microserviceBdd", url = "http://localhost:9001")
public interface MicroserviceBDDProxy {

    @GetMapping(value = "/Books")
    List<BookBean> getBooksList();

    @GetMapping(value = "/Users")
    List<LibraryUserBean> getListOfUsers();
}
