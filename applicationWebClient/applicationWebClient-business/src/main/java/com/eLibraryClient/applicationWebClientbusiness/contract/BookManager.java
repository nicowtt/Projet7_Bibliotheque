package com.eLibraryClient.applicationWebClientbusiness.contract;

import com.eLibraryClient.applicationWebClientmodel.beans.BookBean;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface BookManager {
    List<BookBean> getListAllBooks();
}
