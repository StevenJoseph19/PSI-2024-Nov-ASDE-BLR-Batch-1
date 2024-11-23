/*Creating and Using Locales*/

package org.example.localemgmt;

import java.util.Locale;

public class LocaleDemo {
    public static void main(String[] args) {
        Locale usLocale = Locale.US;
        Locale customLocale = new Locale("fr", "FR");

        System.out.println("Default Locale: " + Locale.getDefault());
        System.out.println("US Locale: " + usLocale.getDisplayName());
        System.out.println("Custom Locale: " + customLocale.getDisplayName());
    }
}
