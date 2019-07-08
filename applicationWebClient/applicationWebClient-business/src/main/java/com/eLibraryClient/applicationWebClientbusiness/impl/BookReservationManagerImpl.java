package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.BookReservationManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.DateManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.BookReservationBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookReservationManagerImpl implements BookReservationManager {

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    @Autowired
    private DateManager dateManager;

    /**
     * For complete date of reservation
     * @param bookReservation
     */
    @Override
    public void completeWithDate(BookReservationBean bookReservation) {
        //get today date
        String todayDate = dateManager.todayDate();
        //get 4 week after date
        String endOfReservationDate = dateManager.addDaysOnTodayDate(28);

        //set reservation dates
        bookReservation.setBeginofreservationdate(todayDate);
        bookReservation.setEndofreservationdate(endOfReservationDate);

        //set extention of reservation
        bookReservation.setExtensionofreservation(false);

        //Write on  microserviceBDD
        microserviceBDDProxy.addReservation(bookReservation);
    }

}
