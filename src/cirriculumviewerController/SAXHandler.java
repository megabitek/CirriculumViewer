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
import model.Task.TaskState;
import model.TaskString;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Elena_Kholkina
 */
class SAXHandler extends DefaultHandler {

    public ArrayList<ReportString> reportList = new ArrayList<>();
    private ReportString reportString = null;
    private ArrayList<TaskString> theoryTasks = null;
    private ArrayList<TaskString> practicTasks = null;
    private TaskString taskStr;

    public HashMap<Integer, Student> studentList = new HashMap();
    private Student student = null;

    public HashMap<Integer, Programm> programmList = new HashMap();
    private Programm programm = null;

    public HashMap<Integer, Course> courseList = new HashMap();

    private Course course = null;

    public HashMap<Integer, Task> practicTasksList = new HashMap();
    public HashMap<Integer, Task> theoryTasksList = new HashMap();
    private Task task = null;

    private String content = null;

    @Override
    public void startElement(String uri, String localName,
            String qName, Attributes attributes)
            throws SAXException {

        switch (qName) {

            case "report": {
                reportString = new ReportString();
                theoryTasks = new ArrayList();
                reportString.setTheoryTasksId(theoryTasks);
                practicTasks = new ArrayList();
                reportString.setPracticTasksId(practicTasks);
              
                break;
            }

            case "theorytask": {
                taskStr = new TaskString();
                break;
            }
            case "practictask": {
                taskStr = new TaskString();
                break;
            }
            case "student": {
                student = new Student();
               

                break;
            }
            case "programm": {
                programm = new Programm();
                programm.setCourses(new ArrayList());
               

                break;
            }
            case "course": {
                course = new Course();
                course.setTheoryTasks(new ArrayList());
                course.setPracticTasks(new ArrayList());
              
                /* student = new Student();
                 student.id = attributes.getValue("studentid");*/
                break;
            }
            case "practic-task": {
                task = new Task();
                task.setType(Task.TaskType.PRACTIC_TASK);
                break;
            }
            case "theory-task": {
                task = new Task();
                task.setType(Task.TaskType.THEORY_TASK);
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName,
            String qName) throws SAXException {
        switch (qName) {
            /*report's Attrs*/
            case "report": {
                reportList.add(reportString);
                /*   reportString=null; 
                 taskStr = null;*/
                break;
            }

            case "studentid": {
                int studentid = Integer.parseInt(content);
                if (student == null) {
                    reportString.setStudentId(studentid);
                    break;
                } else {
                    student.setId(studentid);
                    break;
                }
            }
            case "theorytask": {
                theoryTasks.add(taskStr);
                break;
            }
            case "practictask": {
                practicTasks.add(taskStr);
                break;
            }
            case "theorytaskid": {
                taskStr.setTaskID(Integer.parseInt(content));
                break;
            }
            case "practictaskid": {
                taskStr.setTaskID(Integer.parseInt(content));
                break;
            }
            case "theorytaskstate": {
                taskStr.setTaskState(getTaskStateByString(content));
                break;
            }
            case "practictaskstate": {
                taskStr.setTaskState(getTaskStateByString(content));
                break;
            }
            case "balls": {
                taskStr.setBalls(Integer.parseInt(content));
                break;
            }
            case "courseid": {
                if (course != null) {
                    course.setId(Integer.parseInt(content));
                } else {
                    reportString.setCourseId(Integer.parseInt(content));
                }
                break;
            }
            /*Student parsing*/
            case "student": {
                studentList.put(student.getId(), student);
                break;
            }
            case "name": {
                student.setFullName(content);
                break;
            }
            case "email": {
                student.setEMail(content);
                break;
            }
            case "date-learning-begin": {

                Date docDate = getDateByTag(content);
                if (docDate != null) {
                    student.setLearningBeginDate(docDate);
                }
                break;
            }
            case "contract": {
                student.setContract(Boolean.parseBoolean(content));
                break;
            }
            case "programmid": {
                if (programm == null) {
                    student.setProgrammId(Integer.parseInt(content));
                } else {
                    programm.setId(Integer.parseInt(content));
                }
                break;
            }
            /*Programm parsing*/
            case "programm": {
                programmList.put(programm.getId(), programm);
                break;
            }
            case "title": {
                if (task == null) {
                    if (course == null) {

                        programm.setTitle(content);
                    } else {
                        course.setTitle(content);
                    }
                } else {
                    task.setTitle(content);
                }
                break;
            }
            case "author": {

                if (course == null) {

                    programm.setAuthor(content);
                } else {
                    course.setAuthor(content);
                }

                break;

            }
            case "creation-date": {
                Date docDate = getDateByTag(content);
                if (docDate != null) {
                    programm.setCreationDate(docDate);
                }
                break;
            }
            case "coursesid": {

                programm.getCourses().add(Integer.parseInt(content));

                break;
            }
            case "theory-task-id": {
                if (task == null) {
                    course.getTheoryTasks().add(Integer.parseInt(content));
                } else {
                    task.setID(Integer.parseInt(content));
                }
                break;
            }
            case "practic-task-id": {
                if (task == null) {
                    course.getPracticTasks().add(Integer.parseInt(content));
                } else {
                    task.setID(Integer.parseInt(content));
                }
                break;
            }
            case "course": {
                courseList.put(course.getId(), course);
                break;
            }
            case "practic-task": {
                practicTasksList.put(task.getID(), task);
                break;
            }
            case "theory-task": {
                theoryTasksList.put(task.getID(), task);
                break;
            }
            case "duration": {
                task.setDuration(Integer.parseInt(content));
            }
        }
    }

    TaskState getTaskStateByString(String str) {
        switch (str) {
            case "makingNotBegin":
                return TaskState.MAKING_NOT_BEGIN;
            case "makingInProcess":
                return TaskState.MAKING_IN_PROCESS;
            case "learningNotBegin":
                return TaskState.LEARNING_NOT_BEGIN;
            case "learningEnded":
                return TaskState.LEARNING_ENDED;
            case "exercizeChecking":
                return TaskState.EXERCISE_CHEKING;
            case "exercizeDone":
                return TaskState.EXERCISES_DONE;
            case "learningInProcess":
                return TaskState.LEARNING_IN_PROCESS;
            default:
                return null;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
        // System.out.println(content);
    }

    public Date getDateByTag(String content) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-mm-dd");
        Date docDate;
        try {
            docDate = format.parse(content);
            return docDate;
        } catch (ParseException ex) {
            Logger.getLogger(SAXHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
