package com.eLibrary.moduleDao.dao.dao;

import com.eLibrary.moduleModel.beans.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReservationDao extends JpaRepository<BookReservation, Integer> {
}
