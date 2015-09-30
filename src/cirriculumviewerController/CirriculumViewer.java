/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cirriculumviewerController;

import model.Course;
import model.Programm;
import model.ReportString;
import model.Student;
import model.Task;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import view.MainFrame;

/**
 *
 * @author Elena_Kholkina
 */
public class CirriculumViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here

        SAXParserFactory parserFactor = SAXParserFactory.newInstance();

        SAXParser parser = parserFactor.newSAXParser();

        SAXHandler handler = new SAXHandler();

        parser.parse(new File("Cirriculum.xml"), handler);

        for (ReportString reportStr : handler.reportList) {

            System.out.println(reportStr);

        }
        System.out.println("**********************************************");
        System.out.println("Student's list:");

        for (Student student : handler.studentList) {
            System.out.println(student);
        }

        System.out.println("**********************************************");
        System.out.println("programm's list:");
        
         for (Programm programm : handler.programmList) {
            System.out.println(programm);
        }
  System.out.println("**********************************************");
        System.out.println("course's list:");
        
         for (Course course : handler.courseList) {
            System.out.println(course);
        }
          for (Programm programm : handler.programmList) {
            System.out.println(programm);
        }
  System.out.println("**********************************************");
        System.out.println("practic task's list:");
        
         for (Task task : handler.practicTasksList) {
            System.out.println(task);
        }
         
          System.out.println("**********************************************");
        System.out.println("theory task's list:");
        
         for (Task task : handler.theoryTasksList) {
            System.out.println(task);
        }
         MainFrame frame = new MainFrame(handler.reportList);
         
    }


}
