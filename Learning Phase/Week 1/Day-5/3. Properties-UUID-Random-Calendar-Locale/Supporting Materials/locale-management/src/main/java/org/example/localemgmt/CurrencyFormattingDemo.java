/*Formatting Numbers and Currencies*/

package org.example.localemgmt;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormattingDemo {
    public static void main(String[] args) {
        double value = 12345.67;

        NumberFormat usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat jpCurrency = NumberFormat.getCurrencyInstance(Locale.JAPAN);

        System.out.println("US Currency: " + usCurrency.format(value));
        System.out.println("Japanese Currency: " + jpCurrency.format(value));
    }
}
