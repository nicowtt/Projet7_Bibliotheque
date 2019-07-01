package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import com.eLibraryClient.applicationWebClientmodel.beans.BookReservationBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookReservationManager {
    List<BookBean> askToBddOnWhichLibraryIsBook(int pBookId);
    void writeBookReservationOnBdd(BookReservationBean bookReservationBean);
}
