/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cirriculumviewer;

import domain.Course;
import domain.Programm;
import domain.ReportString;
import domain.Student;
import domain.Task;
import domain.Task.TaskState;
import domain.TaskString;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    
    List<ReportString> reportList = new ArrayList<>();
    ReportString reportString = null;
    ArrayList<TaskString> theoryTasks = null;
    ArrayList<TaskString> practicTasks = null;
    private TaskString taskStr;
    
    List<Student> studentList = new ArrayList<>();
    Student student = null;
    
    List<Programm> programmList = new ArrayList();
    Programm programm = null;
    
    ArrayList<Course> courseList = new ArrayList();
    
    Course course = null;
    
    ArrayList<Task> practicTasksList = new ArrayList();
    ArrayList<Task> theoryTasksList = new ArrayList();
    Task task = null;
    
    String content = null;
    
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
                System.out.println("teg report");
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
                System.out.println("teg students");
                
                break;
            }
            case "programm": {
                programm = new Programm();
                programm.setCourses(new ArrayList());
                System.out.println("teg programms");
                
                break;
            }
            case "course": {
                course = new Course();
                course.setTheoryTasks(new ArrayList());
                course.setPracticTasks(new ArrayList());
                System.out.println("teg courses");
                /* student = new Student();
                 student.id = attributes.getValue("studentid");*/
                break;
            }
            case "practic-task": {
                task = new Task();
                task.setType(Task.TaskType.PRACTIC_TASK);
            break; }
            case "theory-task": {
                task = new Task();
            task.setType(Task.TaskType.THEORY_TASK);
            break;}
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
                studentList.add(student);
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
                programmList.add(programm);
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
                courseList.add(course);
                break;
            }
            case "practic-task": {
                practicTasksList.add(task);
                break;
            }
            case "theory-task": {
                theoryTasksList.add(task);
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
