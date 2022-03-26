import DataMapping.Class;
import DataMapping.Student;
import io.qameta.allure.Step;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Helper {

    public static String getDateTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }

    public static void printFile(String filePath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printClassObject(Class c){
        ArrayList<Student> students = c.getStudents();
        for(Student s : students){
            logToReport("Id: " + s.getId());
            logToReport("First name: " + s.getFirstName());
            logToReport("Last name: " + s.getLastName());
            logToReport("Subject: " + s.getSubject());
            logToReport("Marks: " + s.getMarks());
        }
    }

    @Step("{0}")
    public static void logToReport(String message) {
        System.out.println(message);
    }
}
