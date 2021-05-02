package com.company.task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 2.	Напишите код, который формирует объекты Date и Calendar по следующим данным, вводимым пользователем:
 * <Год><Месяц><Число>
 * <Часы ><минуты>
 * Напишите проверочный класс.
 */
public class Calendar_Date {
    private Calendar calendar;
    private Date date;

    public Calendar_Date(){
        calendar = new GregorianCalendar();
        date = new Date();
    }
    public Date setDateDayMonthYear(int year, int month, int day) throws ParseException {
        this.date = new SimpleDateFormat("dd/MM/yyyy").parse(day + "/" + month + "/" + year);
        return this.date;
    }

    public Date setDateHourMins(int hours, int mins) throws ParseException {
        this.date = new SimpleDateFormat("HH:mm").parse(hours + ":" + mins);
        return this.date;
    }

    public Calendar setCalendarDayMonthYear(int year, int month, int day) {
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        return this.calendar;
    }
    public Calendar setCalendarHourMins(int hours,int mins) {
        calendar.set(Calendar.AM_PM, hours);
        calendar.set(Calendar.MINUTE, mins);
        return this.calendar;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Date getDate() {
        return date;
    }
}
