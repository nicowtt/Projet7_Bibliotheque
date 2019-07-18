package com.eLibraryBatch.batchMailproxies;


import com.eLibraryBatch.batchMailmodel.BookReservationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(name = "microserviceBdd", url = "http://localhost:9001")
public interface MicroserviceBDDProxy {

    //*******************************************//
    //************ Book Reservation *************//
    //*******************************************//

    /**
     * Get all late book reservation
     */
    @GetMapping(value = "/BookReservationLate")
    public List<BookReservationBean>getBookReservationLate();

}
