package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.Enums.CompareDate;
import com.eLibraryClient.applicationWebClientbusiness.contract.BookReservationManager;
import com.eLibraryClient.applicationWebClientbusiness.contract.DateManager;
import com.eLibraryClient.applicationWebClientmodel.beans.BookReservationBean;
import com.eLibraryClient.applicationWebClientproxies.proxies.MicroserviceBDDProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.eLibraryClient.applicationWebClientbusiness.Enums.CompareDate.ISAFTER;
import static com.eLibraryClient.applicationWebClientbusiness.Enums.CompareDate.ISBEFORE;
import static com.eLibraryClient.applicationWebClientbusiness.Enums.CompareDate.ISTODAY;

@Component
public class BookReservationManagerImpl implements BookReservationManager {

    Logger logger = LoggerFactory.getLogger(this.getClass());

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

    /**
     * Get a list of reservation in progress
     * @return
     */
    @Override
    public List<BookReservationBean> bookReservationInProgressList() {

        CompareDate beginCompareEnum = ISBEFORE;

        //get all reservations
        List<BookReservationBean> allReservations = microserviceBDDProxy.getAllReservation();

        //create a list of reservation is in progress
        List<BookReservationBean> reservationInProgress = new ArrayList<>();

        for (int i = 0; i < allReservations.size(); i++) {
            String beginOfReservationDate = allReservations.get(i).getBeginofreservationdate();
            String endOfReservationDate = allReservations.get(i).getEndofreservationdate();

            beginCompareEnum = dateManager.compareDateWithToday(beginOfReservationDate);
            if ((beginCompareEnum == ISTODAY
                    || beginCompareEnum == ISAFTER)
                    && !allReservations.get(i).isBookback()) {
                reservationInProgress.add(allReservations.get(i));
            }

        }

        return reservationInProgress;

    }

    /**
     * Count Reservation in progress for one book
     * @param bookId
     * @return
     */
    @Override
    public int countReservationInProgressForOneBook(int bookId) {
        int bookReservationInProgress = 0;

        //get all reservation in progress
        List<BookReservationBean> reservationinProgress = bookReservationInProgressList();

        //count for one book
        for (int i = 0; i < reservationinProgress.size(); i++) {
            if (reservationinProgress.get(i).getBook_id() == bookId) {
                bookReservationInProgress++;
            }
        }
        return bookReservationInProgress;
    }

}
