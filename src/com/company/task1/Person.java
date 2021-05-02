package com.company.task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 1.	Разработайте класс Person для хранения даты рождения, напишите метод toString(),
 *      разработайте метод, возвращающий строковое представление даты рождения по вводимому
 *      в метод формату даты (например, короткий, средний и полный формат даты).
 */
public class Person {
    private Date dateOfBirth;
    public Person(int year,int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month-1); // потом что с нуля начинается
        cal.set(Calendar.DAY_OF_MONTH,day);
        dateOfBirth = cal.getTime();
    }
    public String toString(String type){
        String output = "";
        SimpleDateFormat formatter;
        switch (type){
            case "полный":
                 formatter = new SimpleDateFormat("EEEEEEE, d MMMMMMM yyyy");
                output= formatter.format(dateOfBirth);
                break;
            case "средний":
                formatter = new SimpleDateFormat("dd MMMMM yyyy");
                output= formatter.format(dateOfBirth);
                break;
            case "короткий":
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                output= formatter.format(dateOfBirth);
                break;
        }
        return output;
    }
}
