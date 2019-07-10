package com.eLibrary.moduleDao.dao.dao;

import com.eLibrary.moduleModel.beans.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookReservationDao extends JpaRepository<BookReservation, Integer> {

    List<BookReservation> getBookReservationsByUserId(int userId);
}
