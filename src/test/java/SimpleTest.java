import DataMapping.Class;
import io.qameta.allure.Step;
import org.testng.annotations.*;

public class SimpleTest {

    static String dataPath;

    @BeforeClass
    public void setUp() {
        System.out.println("Test Started: " + Helper.getDateTime());
        System.out.println("Loading properties file...");
        PropertiesFile.initProperties();
        System.out.println("Running in the " + PropertiesFile.prop.getProperty("environment") + " environment.");
        System.out.println("Data path: " + PropertiesFile.projectPath + PropertiesFile.prop.getProperty("testDataFilePath"));
        dataPath = PropertiesFile.projectPath + PropertiesFile.prop.getProperty("testDataFilePath");

    }

    @AfterClass
    public void tearDown(){
        System.out.println("Testing Completed: " + Helper.getDateTime());
    }

    @DataProvider(name="data-provider")
    public Object[][] getData(){
        return new Object[][] {{"test.xml"}, {"test2.xml"}, {"test3.xml"}};

    }

    @Test (dataProvider="data-provider", description = "Validate input against output from system")
    public void helloTest(String dataValue) {
        System.out.println("Parsing file: " + dataValue);
        //printRawFile(dataValue);
        printFormattedFile(dataValue);
    }

    @Step ("Print out raw {0} file")
    public void printRawFile(String dataValue){
        Helper.printFile(dataPath + dataValue);
    }

    @Step ("Print out formatted {0} file")
    public void printFormattedFile(String dataValue){
        Class c = XMLHelper.parseXMLFileToClassObject(dataPath + dataValue);
        Helper.printClassObject(c);
    }

}

