package by.userTable.commands;

import java.util.ResourceBundle;

/**
 * Created by Narek on 12/11/2015.
 */
public class PageManager {
    private final static ResourceBundle resource_bundle = ResourceBundle
            .getBundle("path");

    private PageManager() {
    }

    public static String getProperty(String key) {
        return resource_bundle.getString(key);
    }
}
