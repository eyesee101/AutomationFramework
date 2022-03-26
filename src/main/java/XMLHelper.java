import DataMapping.Class;
import DataMapping.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XMLHelper {

    public static Class parseXMLFileToClassObject(String filePath){
        //This method will take our XML test data, parse it and create a "Class" object filled with Students.
        Class c = null;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file using input file path
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filePath));

            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element of XML: " + doc.getDocumentElement().getNodeName());

            //Get Students
            NodeList studentList = doc.getElementsByTagName("student");

            //Create new ArrayList of Students
            ArrayList<Student> students = new ArrayList<>();

            //Create new Class, and add the list of Students just created
            c = new Class(students);

            //Loop through students and add them to a data class
            for(int i = 0; i < studentList.getLength(); i++){
                Node node = studentList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    //Get attributes
                    int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                    String firstName = element.getElementsByTagName("firstname").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("lastname").item(0).getTextContent();
                    String subject = element.getElementsByTagName("subject").item(0).getTextContent();
                    int marks = Integer.parseInt(element.getElementsByTagName("marks").item(0).getTextContent());

                    //Debug printing
                    /*System.out.println("Current Element :" + node.getNodeName());
                    System.out.println("Id : " + id);
                    System.out.println("First Name : " + firstName);
                    System.out.println("Last Name : " + lastName);
                    System.out.println("Subject : " + subject);
                    System.out.println("Marks : " + marks);

                     */

                    //Create Student object
                    Student s = new Student(id, firstName, lastName, subject, marks);

                    //Add student to Class
                    c.addStudent(s);

                }
            }


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return c;

    }

}
