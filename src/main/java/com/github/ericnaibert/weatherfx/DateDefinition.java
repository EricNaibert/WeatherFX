package com.github.ericnaibert.weatherfx;

import java.util.Date;

public class DateDefinition {

    public static String tomorrowDate;
    public static String afterTomorrowDate;

    public static void currentDate() {

        Date date = new Date();
        String dateToString = String.valueOf(date);
        String[] dayOfTheWeek = dateToString.split(" ");
        tomorrowDate = tomorrow(dayOfTheWeek[0]);
        afterTomorrowDate = afterTomorrow(dayOfTheWeek[0]);
    }

    public static String tomorrow(String today) {

        return switch (today) {
            case "Mon" -> "Tuesday";
            case "Tue" -> "Wednesday";
            case "Wed" -> "Thursday";
            case "Thu" -> "Friday";
            case "Fri" -> "Saturday";
            case "Sat" -> "Sunday";
            case "Sun" -> "Monday";
            default -> "Today";
        };
    }

    public static String afterTomorrow(String today) {

        return switch (today) {
            case "Mon" -> "Wednesday";
            case "Tue" -> "Thursday";
            case "Wed" -> "Friday";
            case "Thu" -> "Saturday";
            case "Fri" -> "Sunday";
            case "Sat" -> "Monday";
            case "Sun" -> "Tuesday";
            default -> "Today";
        };
    }

}
