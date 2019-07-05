package com.eLibrary.moduleDao.dao.dao;

import com.eLibrary.moduleModel.beans.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryDao extends JpaRepository<Library, Integer> {

    Library findByLibraryname(String libraryName);


}
