package org.project.date_class;

import org.project.vehicle_support.Car;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateClass{

    public static int insuranceDataRemaining(Car car) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        dateFormat.format(date);
        System.out.println(dateFormat.format(date));
        String date2 = car.getInsuranceTime();
        int result = 0;
        try {
            Date toDate = dateFormat.parse(date2);
            Date fromDate = dateFormat.parse(dateFormat.format(date));
            long diff = toDate.getTime() - fromDate.getTime();
            result = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();


        }
        return result;
    }
    public static int techInspectionDataRemaining(Car car) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        dateFormat.format(date);
        String date2 = car.getTechInspectionDate();
        int result = 0;
        try {
            Date toDate = dateFormat.parse(date2);
            Date fromDate = dateFormat.parse(dateFormat.format(date));
            long diff = toDate.getTime() - fromDate.getTime();
            result = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println("Difference in Days: " + result);
        } catch (ParseException e) {
            e.printStackTrace();


        }
        return result;
    }
}
