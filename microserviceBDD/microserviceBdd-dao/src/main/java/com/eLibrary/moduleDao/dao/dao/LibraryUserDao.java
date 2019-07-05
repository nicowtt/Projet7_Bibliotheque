package com.eLibrary.moduleDao.dao.dao;

import com.eLibrary.moduleModel.beans.Libraryuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryUserDao extends JpaRepository<Libraryuser, Integer> {

    Libraryuser findByUseremail(String useremail);
}
