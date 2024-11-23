/*Formatting Dates with SimpleDateFormat*/

package org.example.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarFormatting {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        // Format the date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatted Date: " + formatter.format(calendar.getTime()));

        // Custom date manipulation
        calendar.add(Calendar.DAY_OF_MONTH, 7); // Add 7 days
        System.out.println("One Week Later: " + formatter.format(calendar.getTime()));
    }
}
