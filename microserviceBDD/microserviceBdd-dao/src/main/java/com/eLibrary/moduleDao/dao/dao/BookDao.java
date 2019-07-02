package com.eLibrary.moduleDao.dao.dao;

import com.eLibrary.moduleModel.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

//    @Query("SELECT '*' FROM book WHERE book.id = :Id")
//    List<Book> listBookAnyLibraries(@Param("Id") int Id);
}
