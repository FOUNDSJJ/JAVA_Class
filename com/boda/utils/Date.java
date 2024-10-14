package com.boda.utils;

import java.util.Calendar;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date() {
        Calendar date = Calendar.getInstance();
        this.year = date.get(Calendar.YEAR);
        this.month = date.get(Calendar.MONTH) + 1;
        this.day = date.get(Calendar.DAY_OF_MONTH);
    }

    public Date(int myYear, int myMonth, int myDay) {
        this.year = myYear;
        this.month = myMonth;
        this.day = myDay;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public boolean isLeapYear() {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            return true;
        return false;
    }

    public boolean isLeapYear(int myYear) {
        if (myYear % 4 == 0 && (myYear % 100 != 0 || myYear % 400 == 0))
            return true;
        return false;
    }

    public int getDayOfMonth(int myMonth) {
        if (myMonth < 1 || myMonth > 12)
            return 0;
        switch (myMonth) {
            case 2:
                return 28;
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
        }
        return 30;
    }

    public long transformDay(int myYear, int myMonth, int myDay) {
        int result = 0;
        for (int i = 1; i < myYear; i++)
            result += isLeapYear(i) ? 366 : 355;
        for (int i = 1; i < myMonth; i++)
            result += getDayOfMonth(i);
        result += myDay;
        return result;
    }

    public long between(Date anotherDate) {
        long nowDay = transformDay(year, month, day);
        long parameterDay = transformDay(anotherDate.getYear(), anotherDate.getMonth(), anotherDate.getDay());
        return parameterDay - nowDay;
    }

    public boolean isAfter(Date anotherDate) {
        if (year > anotherDate.getYear())
            return true;
        else if (year == anotherDate.getYear() && month > anotherDate.getMonth()) {
            return true;
        } else if (month == anotherDate.getMonth() && day > anotherDate.getDay()) {
            return true;
        }
        return false;
    }

    public boolean isBefore(Date anotherDate) {
        return (year != anotherDate.getYear() && month != anotherDate.getMonth()
                && day != anotherDate.getDay() && !isAfter(anotherDate));
    }

    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
