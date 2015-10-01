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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import model.TaskString;
import org.xml.sax.SAXException;
import view.MainFrame;

/**
 *
 * @author Elena_Kholkina
 */
public class CirriculumViewer {

   

    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here

        

        /* for (ReportString reportStr : handler.reportList) {

         System.out.println(reportStr);

         }/*
         System.out.println("**********************************************");
         System.out.println("Student's list:");

         for (Map.Entry<Integer, Student> entry : handler.studentList.entrySet()) {
         System.out.printf("key = %s, value = %s\r\n", entry.getKey(), entry.getValue());
         }

         System.out.println("**********************************************");
         System.out.println("programm's list:");

         for (Map.Entry<Integer, Programm> entry : handler.programmList.entrySet()) {
         System.out.printf("key = %s, value = %s\r\n", entry.getKey(), entry.getValue());
         }
         System.out.println("**********************************************");
         System.out.println("course's list:");

         for (Map.Entry<Integer, Course > entry : handler.courseList.entrySet()) {
         System.out.printf("key = %s, value = %s\r\n", entry.getKey(), entry.getValue());
         }
       
         System.out.println("**********************************************");
         System.out.println("practic task's list:");

         for (Map.Entry<Integer, Task> entry : handler.practicTasksList.entrySet()) {
         System.out.printf("key = %s, value = %s\r\n", entry.getKey(), entry.getValue());
         }
         System.out.println("**********************************************");
         System.out.println("theory task's list:");

         for (Map.Entry<Integer, Task> entry : handler.theoryTasksList.entrySet()) {
         System.out.printf("key = %s, value = %s\r\n", entry.getKey(), entry.getValue());
         }*/
        Controller controller = new Controller();
        controller.init();
        MainFrame frame = new MainFrame(controller.getReportStrings());

    }

   
}
