/*Basic Calendar Operations */

package org.example.calendar;

import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        // Create an instance of Calendar
        Calendar calendar = Calendar.getInstance();

        // Display current date and time
        System.out.println("Current Date and Time: " + calendar.getTime());

        // Get specific fields
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // Months are 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("Year: " + year + ", Month: " + (month + 1) + ", Day: " + day);

        // Modify the calendar
        calendar.set(Calendar.YEAR, 2025);
        calendar.add(Calendar.MONTH, 2); // Add 2 months
        calendar.roll(Calendar.DAY_OF_MONTH, -10); // Roll back 10 days without affecting month
        System.out.println("Updated Date: " + calendar.getTime());
    }
}
