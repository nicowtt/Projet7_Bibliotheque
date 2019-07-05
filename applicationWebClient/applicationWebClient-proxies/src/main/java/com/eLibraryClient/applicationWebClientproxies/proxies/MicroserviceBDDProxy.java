package com.eLibraryClient.applicationWebClientproxies.proxies;


import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryBean;
import com.eLibraryClient.applicationWebClientmodel.beans.LibraryUserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sun.awt.SunHints;

import java.util.List;

@Component
@FeignClient(name = "microserviceBdd", url = "http://localhost:9001")
public interface MicroserviceBDDProxy {

    //************ BOOK *************************//

    /**
     * asking list of all books on microserviceBDD
     * @return
     */
    @GetMapping(value = "/Books")
    List<BookBean> getBooksList();


    /**
     * Asking list of book (only version of one book)
     * -> user will choice library
     * @return
     */
    @GetMapping(value = "/Book/{id}")
    BookBean getOneBook(@PathVariable("id") Integer id);


    //************ USER *************************//
    /**
     * Asking list of all users on microserviceBDD
     * @return
     */
    @GetMapping(value = "/Users")
    List<LibraryUserBean> getListOfUsers();

    /**
     * Asking one user bean
     * @param pEmail
     * @return
     */
    @GetMapping(value = "/User/{email}")
    LibraryUserBean getOneUser(@PathVariable("email") String pEmail);

    /**
     * Write new user on microserviceBDD
     * @param libraryUserBean -> new user bean
     * @return
     */
    @PostMapping(value = "/NewUser")
    LibraryUserBean addUser(@RequestBody LibraryUserBean libraryUserBean);

    //************ Library *************************//

    /**
     * get one library
     * @param name
     * @return
     */
    @GetMapping(value = "/Library/{name}")
    LibraryBean getOneLibrary(@PathVariable("name") String name);
}
