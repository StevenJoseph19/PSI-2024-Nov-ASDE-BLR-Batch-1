/*Using Resource Bundles for Localization*/

package org.example.localemgmt;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {
    public static void main(String[] args) {
        Locale locale = new Locale("es", "ES"); // Spanish
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        System.out.println(bundle.getString("greeting"));
    }
}
