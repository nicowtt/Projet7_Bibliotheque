package com.eLibrary.moduleDao.dao.dao;

import com.eLibrary.moduleModel.beans.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookReservationDao extends JpaRepository<BookReservation, Integer> {

    List<BookReservation> getBookReservationsByUserId(int userId);

    @Modifying
    @Query(value = "UPDATE bookreservation  SET endofreservationdate = ?1 , extensionofreservation = true WHERE id = ?2", nativeQuery = true)
    void updateBookReservationExtendEndDate(String newDate, int reservationId);
}
