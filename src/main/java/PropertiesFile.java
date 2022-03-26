import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");

    public static void initProperties() {
        try {
            InputStream input = new FileInputStream(projectPath + "/src/main/resources/config.properties");
            prop.load(input);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void setProperty(String property, String value) {
        try {
            OutputStream output = new FileOutputStream(projectPath + "/src/test/java/test/config.properties");
            prop.setProperty(property, value);
            prop.store(output, "setting " + value + " to " + property);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
