package com.company.task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CheckDate {
    private Calendar_Date calendar_date = new Calendar_Date();
    public CheckDate(int year, int month, int day) throws ParseException {
        calendar_date.setDateDayMonthYear(year, month, day);
        calendar_date.setCalendarDayMonthYear(year, month, day);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormatter.format(calendar_date.getDate()));
        System.out.println(calendar_date.getCalendar().getTime());
    }
    public CheckDate(int hours, int min) throws ParseException {
        calendar_date.setCalendarHourMins(hours, min);
        calendar_date.setDateHourMins(hours, min);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println(dateFormatter.format(calendar_date.getDate()));
        System.out.println(calendar_date.getCalendar().getTime());
    }
}
