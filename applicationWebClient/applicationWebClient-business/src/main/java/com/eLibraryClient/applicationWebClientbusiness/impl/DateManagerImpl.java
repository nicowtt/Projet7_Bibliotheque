package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.Enums.CompareDate;
import com.eLibraryClient.applicationWebClientbusiness.contract.DateManager;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateManagerImpl implements DateManager {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * for today date (dd/MM/yyyy)
     *
     * @return
     */
    @Override
    public String todayDate() {

        Calendar calendar = Calendar.getInstance();

        //template
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");

        return simpleDate.format(calendar.getTime());
    }

    /**
     * For add days to today date (dd/MM/yyyy))
     *
     * @param pNbrOfDay -> number of days to add
     * @return
     */
    @Override
    public String addDaysOnTodayDate(int pNbrOfDay) {

        Calendar calendar = Calendar.getInstance();

        //template
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");

        //add days
        calendar.add(Calendar.DATE, pNbrOfDay);

        return simpleDate.format(calendar.getTime());
    }

    /**
     * For compare one date with today date
     * @param pDate -> date for compare
     * @return-> enum CompareDate
     */
    @Override
    public CompareDate compareDateWithToday(String pDate) {

        Date newDate = null;
        CompareDate CompareDateEnum = CompareDate.ISBEFORE;

        Calendar todayDate = Calendar.getInstance(); // 1st calendar is current date/time
        Calendar dateToCompare = Calendar.getInstance(); // 2eme calendar is date to compare

        //template
        DateFormat dateFormated = new SimpleDateFormat("dd/MM/yyyy");

        // convert input on Date
        try {
            newDate = dateFormated.parse(pDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //set 2em calendar
        dateToCompare.setTime(newDate);

        //for display(check)
        String todayDateString = dateFormated.format(todayDate.getTime());
        String dateToCompareString = dateFormated.format(dateToCompare.getTime());

        //Compare dates
        if (todayDate.equals(dateToCompare)) {
            logger.debug(todayDateString + " is the same as " + dateToCompareString);

            CompareDateEnum = CompareDate.ISTODAY;
        }

        if (todayDate.after(dateToCompare)) {
            logger.debug(todayDateString + " is after " + dateToCompareString);

            CompareDateEnum = CompareDate.ISAFTER;
        }

        if (todayDate.before(dateToCompare)) {
            logger.debug(todayDateString + " is before " + dateToCompareString);

            CompareDateEnum = CompareDate.ISBEFORE;
        }

        return CompareDateEnum;

    }


//        //comparaison
//        Calendar someCalendar1 = Calendar.getInstance(); // current date/time
//        someCalendar1.add(Calendar.DATE, -11);
//
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        Date someDate = null;
//        try {
//            someDate = df.parse("01/07/2099");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar someCalendar2 = Calendar.getInstance();
//        someCalendar2.setTime(someDate);
//
//        String cal1 = df.format(someCalendar1.getTime());
//        String cal2 = df.format(someCalendar2.getTime());
//
//        if (someCalendar1.equals(someCalendar2)) {
//            System.out.println(cal1 + " is the same as " + cal2);
//        }
//
//        if (someCalendar1.after(someCalendar2)) {
//            System.out.println(cal1 + " is after " + cal2);
//        }
//
//        if (someCalendar1.before(someCalendar2)) {
//            System.out.println(cal1 + " is before " + cal2);
//        }



}
