package tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig extends TestBase {
    
    public static String readFromConfigProperties(String fileName, String key){
        Properties properties = new Properties();
        String workingDirectory = System.getProperty("user.dir");

        String value;
        try {
            properties.load(new FileInputStream(workingDirectory+ File.separator+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        value = properties.getProperty(key);
        return value;
    }

    public static String readFromConfigProperties(String key){
        Properties properties = new Properties();
        String workDirectory = System.getProperty("user.dir");

        String value;
        try {
            properties.load(new FileInputStream(workDirectory+File.separator+"config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        value = properties.getProperty(key);
        return value;
    }
}
