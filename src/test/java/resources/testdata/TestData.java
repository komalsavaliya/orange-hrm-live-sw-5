package resources.testdata;

import org.testng.annotations.DataProvider;


public class TestData {
    @DataProvider(name = "Credentials")
    public Object[][] getCredential() {
        Object[][] data = new Object[][]{
                {" ", " ", "Required"},
                {"test123@gmail.com", " ", "Required"},
                {" ", "test123", "Required"},
                {"test123@gmail.com", "test123", "Invalid credentials"}
        };
        return data;
    }


    @DataProvider(name = "Data Set")
    public Object[][] getData() {
        Object[][] data = new Object[][]{

                {"Admin", "Admin", "Paul Collings", "Enable"},
                {"Cassidy.Hope", "ESS", "Cassidy Hope", "Enable"},
                {"Nina.Patel", "ESS", "Nina Patel", "Enable"},
                {"Odis.Adalwin", "Admin", "Odis Adalwin", "Enable"}
        };
        return data;
    }

}

