package com.eLibraryBatch.batchMailbusiness.Impl;

import com.eLibraryBatch.batchMailmodel.BookReservationBean;
import com.eLibraryBatch.batchMailproxies.MicroserviceBDDProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class EmailService {

    @Qualifier("getJavaMailSender")
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private MicroserviceBDDProxy microserviceBDDProxy;

    /**
     * For send email to people who didn't bring back books
     */
    @PostConstruct
    public void sendEmailToLateBookReservation() {
        String to = "";
        String subject = "";
        String text = "";

        //get late book reservation list from microserviceBDD
        List<BookReservationBean> lateBookReservation =
                microserviceBDDProxy.getBookReservationLate();

        // send email for each reservation
        for (int i = 0; i < lateBookReservation.size(); i++) {
            //information for mail
            to = lateBookReservation.get(i).getLibraryuser().getUseremail();
            subject = "Rappel, date de fin de réservation dépassé !";
            text = "Bonjour " + lateBookReservation.get(i).getLibraryuser().getUserfirstname() + "," +
                    "\nLa date de retour maximale pour le livre: " + lateBookReservation.get(i).getBook().getBookname() +
                    " de " + lateBookReservation.get(i).getBook().getBookauthor() +
                    " était le: " + lateBookReservation.get(i).getEndOfReservationDate() + " !" +
                    "\nMerci de ramener le livre au plus tôt dans la bibliothèque: " +
                    lateBookReservation.get(i).getLibrary().getLibraryname() + " !";

            //send mail
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("nicobod31@gmail.com"); //only for development time
//            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
    }
    }
}
