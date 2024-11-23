/*Advanced: Customizing Locale*/

package org.example.calendar;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalendarWithLocale {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        // Display date in French locale
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
        System.out.println("Date in French Locale: " + dateFormat.format(calendar.getTime()));
    }
}
