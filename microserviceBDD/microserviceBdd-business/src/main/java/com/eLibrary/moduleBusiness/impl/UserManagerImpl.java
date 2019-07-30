package com.eLibrary.moduleBusiness.impl;

import com.eLibrary.moduleBusiness.contract.PasswordEncoder;
import com.eLibrary.moduleBusiness.contract.UserManager;
import com.eLibrary.moduleDao.dao.dao.LibraryUserDao;
import com.eLibrary.moduleModel.beans.Libraryuser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private LibraryUserDao libraryUserDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    static final Log logger = LogFactory.getLog(UserManagerImpl.class);

    @Override
    public boolean checkIfMailExist(String mail) {
        boolean mailExist = false;

        Libraryuser oneUser = libraryUserDao.findByUseremail(mail);
        if (oneUser != null) {
            mailExist = true;
        } else {
            logger.info("L'utilisateur: " + mail + " n'existe pas en BDD.");
        }
        return mailExist;
    }

    /**
     * For check if user mail and password is ok
     *
     * @param userBeanInput
     * @return
     */
    @Override
    public boolean checkIfUserMailAndPassIsOk(Libraryuser userBeanInput) {
        Libraryuser userOnBdd = new Libraryuser();
        boolean mailExist = false;
        boolean passwordIsValid = false;
        boolean mailAndUserExist = false;

        // check if email exist on bdd
        mailExist = this.checkIfMailExist(userBeanInput.getUseremail());

        if (mailExist) {
            // va chercher le bean user correspondant en BDD
            userOnBdd = libraryUserDao.findByUseremail(userBeanInput.getUseremail());
            //compare password
            passwordIsValid = passwordEncoder.checkPassword(userBeanInput.getUserpassword(), userOnBdd.getUserpassword());
            if (passwordIsValid) {
                mailAndUserExist = true;
                logger.info("L'utilisateur " + userBeanInput.getUseremail() + " est validé.");
            } else {
                logger.info("L'utilisateur " + userBeanInput.getUseremail() + " n'a pas rentré le bon mot de passe.");
            }
        }
        return mailAndUserExist;
    }
}
