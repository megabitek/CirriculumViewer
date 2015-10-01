/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cirriculumviewerController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import model.Course;
import model.Programm;
import model.ReportString;
import model.Student;
import model.Task;
import model.TaskString;
import model.Tree;
import org.xml.sax.SAXException;

/**
 *
 * @author Elena_Kholkina
 */
public class Controller {

    public static SAXHandler handler;

    void init() throws SAXException, ParserConfigurationException, IOException {

        SAXParserFactory parserFactor = SAXParserFactory.newInstance();

        SAXParser parser = parserFactor.newSAXParser();

        handler = new SAXHandler();

        parser.parse(new File("Cirriculum.xml"), handler);
        addProgrammsInStudents();
        addCoursesInProgramms();
        addTasksInCourses();
        
        
    }

    public Student getStudentById(int id) {
        return handler.studentList.get(id);
    }

    public Programm getProgrammById(int id) {
        return handler.programmList.get(id);
    }

    public Course getCourseById(int id) {
        return handler.courseList.get(id);
    }

    public Task getTheoryTaskById(int id) {
        return handler.theoryTasksList.get(id);
    }

    public Task getPracticTaskById(int id) {
        return handler.practicTasksList.get(id);
    }

    public ArrayList<ReportString> getReportStrings() {
        return handler.reportList;
    }

 
//public ArrayList<> createTreeForView()

    public void addProgrammsInStudents() {
        for (Map.Entry<Integer, Student> entry : handler.studentList.entrySet()) {
            Student student = entry.getValue();
            student.setProgrammObject(getProgrammById(student.getProgrammId()));
            entry.setValue(student);
        }
    }

    public void addCoursesInProgramms() {
        for (Map.Entry<Integer, Programm> entry : handler.programmList.entrySet()) {
            Programm programm = entry.getValue();
            ArrayList<Integer> courses = programm.getCourses();
            ArrayList<Course> coursesObj = new ArrayList();
            for (Iterator<Integer> i = courses.iterator(); i.hasNext();) {
                int courseId = i.next();
                coursesObj.add(getCourseById(courseId));
            }
            programm.setCoursesObjects(coursesObj);
            entry.setValue(programm);
        }

    }

    public void addTasksInCourses() {
        for (Map.Entry<Integer, Course> entry : handler.courseList.entrySet()) {
            Course course = entry.getValue();
            ArrayList<Integer> practicTasksId = course.getPracticTasks();
            ArrayList<Task> practicTaskObj = new ArrayList();
            for (Iterator<Integer> i = practicTasksId.iterator(); i.hasNext();) {
                int taskId = i.next();
                practicTaskObj.add(getPracticTaskById(taskId));
            }
            course.setPracticTasksObjects(practicTaskObj);
            ArrayList<Integer> theoryTasksId = course.getTheoryTasks();
            ArrayList<Task> theoryTasksObj = new ArrayList();
            for (Iterator<Integer> i = theoryTasksId.iterator(); i.hasNext();) {
                int taskId = i.next();
                theoryTasksObj.add(getTheoryTaskById(taskId));
            }
            course.setTheoryTasksObjects(theoryTasksObj);
            entry.setValue(course);
        }
    }

}
