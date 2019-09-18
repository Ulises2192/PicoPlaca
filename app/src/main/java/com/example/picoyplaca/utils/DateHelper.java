package com.example.picoyplaca.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public static String getDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return df.format(c.getTime());
    }

    public static String getHour() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.format(c.getTime());
        return df.format(c.getTime());
    }

    public static String getDay(){
        Calendar c = Calendar.getInstance();
        int mYear, mMonth, mDay;
        Calendar mcurrentDate = Calendar.getInstance();
        mYear = mcurrentDate.get(Calendar.YEAR);
        mMonth = mcurrentDate.get(Calendar.MONTH);
        mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        c.set(mYear,mMonth,mDay);
        int dia =  c.get(Calendar.DAY_OF_WEEK);

        switch (dia){
            case Calendar.MONDAY:
                return Constants.DAY_OF_WEEK.MONDAY;
            case Calendar.TUESDAY:
                return Constants.DAY_OF_WEEK.TUESDAY;
            case Calendar.WEDNESDAY:
                return Constants.DAY_OF_WEEK.WEDNESDAY;
            case Calendar.THURSDAY:
                return Constants.DAY_OF_WEEK.THURSDAY;
            case Calendar.FRIDAY:
                return Constants.DAY_OF_WEEK.FRIDAY;
            case Calendar.SATURDAY:
                return Constants.DAY_OF_WEEK.SATURDAY;
            case Calendar.SUNDAY:
                return Constants.DAY_OF_WEEK.SUNDAY;
                default:
                    return Constants.DAY_OF_WEEK.MONDAY;
        }
    }

    public static boolean intoOfRangeMorning(String hourCurrent){
        try {
            DateFormat dateFormat = new SimpleDateFormat ("hh:mm:ss");

            String hora1 = "07:00:00";
            String hora2 = "11:59:99";

            Date date1, date2, dateNueva;
            date1 = dateFormat.parse(hora1);
            date2 = dateFormat.parse(hora2);
            dateNueva = dateFormat.parse(hourCurrent);

            if ((date1.compareTo(dateNueva) <= 0) && (date2.compareTo(dateNueva) >= 0)){
                System.out.println("La hora " + hourCurrent + " está entre " + hora1 + " y " + hora2);
                return true;
            } else {
                System.out.println("La hora " + hourCurrent + " no está entre " + hora1 + " y " + hora2);
                return false;
            }
        } catch (ParseException parseException){
            parseException.printStackTrace();
            return false;
        }
    }

    public static boolean intoOfRangeEvening(String hourCurrent){
        try {
            DateFormat dateFormat = new SimpleDateFormat ("hh:mm:ss");

            String hora1 = "12:00:00";
            String hora2 = "19:30:00";

            Date date1, date2, dateNueva;
            date1 = dateFormat.parse(hora1);
            date2 = dateFormat.parse(hora2);
            dateNueva = dateFormat.parse(hourCurrent);

            if ((date1.compareTo(dateNueva) <= 0) && (date2.compareTo(dateNueva) >= 0)){
                System.out.println("La hora " + hourCurrent + " está entre " + hora1 + " y " + hora2);
                return true;
            } else {
                System.out.println("La hora " + hourCurrent + " no está entre " + hora1 + " y " + hora2);
                return false;
            }
        } catch (ParseException parseException){
            parseException.printStackTrace();
            return false;
        }

    }
}
