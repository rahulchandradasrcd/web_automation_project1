package Utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidCredentials")
    public static Object InvalidCredentials(){
        Object[][] data = {
                {"litecic778@edectus.com", "passhfh", "Your email or password is incorrect!", ""},
                {"litecic778@ctus.com", "passhfh", "Your email or password is incorrect!", ""},
                {"litecic778@ctus.com", "Luis5555@", "Your email or password is incorrect!", ""},
                {"", "", "", "Please fill out this field."},
                {"litecic778@ctus.com", "", "", "Please fill out this field."}
        };
        return data;
    }
}
