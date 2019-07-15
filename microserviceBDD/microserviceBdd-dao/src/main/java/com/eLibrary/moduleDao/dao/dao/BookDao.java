package com.eLibrary.moduleDao.dao.dao;

import com.eLibrary.moduleModel.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface BookDao extends JpaRepository<Book, Integer> {

    @Modifying
    @Query(value = "UPDATE book set allbookreserved = ?2 WHERE id = ?1", nativeQuery = true)
    void changeDisponibilityForOneBook(int bookId, boolean booleanStatus);

}
