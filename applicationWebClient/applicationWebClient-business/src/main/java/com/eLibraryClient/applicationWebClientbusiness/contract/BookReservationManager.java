package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientmodel.beans.BookReservationBean;
import org.springframework.stereotype.Service;


@Service
public interface BookReservationManager {
    void writeBookReservationOnBdd(BookReservationBean bookReservationBean);
}
