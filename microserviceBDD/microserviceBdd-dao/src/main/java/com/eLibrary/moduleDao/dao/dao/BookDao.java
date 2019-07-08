package com.eLibrary.moduleDao.dao.dao;

import com.eLibrary.moduleModel.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE book  SET allbookreserved = true WHERE id = ?1", nativeQuery = true)
    void changeDisponibilityToTrueForOneBook(int bookId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE book  SET allbookreserved = false WHERE id = ?1", nativeQuery = true)
    void changeDisponibilityToFalseForOneBook(int bookId);

}
