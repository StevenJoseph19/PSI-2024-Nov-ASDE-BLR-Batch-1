/*Formatting Dates and Times*/

package org.example.localemgmt;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormattingDemo {
    public static void main(String[] args) {
        Date now = new Date();

        DateFormat usDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
        DateFormat frDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);

        System.out.println("US Date: " + usDate.format(now));
        System.out.println("French Date: " + frDate.format(now));
    }
}
