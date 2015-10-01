/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Task.TaskState;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Elena_Kholkina
 */
public class ReportString {

    private int studentId;
    private int courseId;
    private ArrayList<TaskString> theoryTasksId;
    private ArrayList<TaskString> practicTasksId;

    public ReportString() {
    }

    public ReportString(int studentId, int courseId, ArrayList<TaskString> theoryTasksId, ArrayList<TaskString> practicTasksId, int ball) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.theoryTasksId = theoryTasksId;
        this.practicTasksId = practicTasksId;

    }

    public void setStudentId(int studentid) {
        this.studentId = studentid;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setPracticTasksId(ArrayList<TaskString> practicTasksId) {
        this.practicTasksId = practicTasksId;
    }

    public ArrayList<TaskString> getPracticTasksId() {
        return this.practicTasksId;
    }

    public void setTheoryTasksId(ArrayList<TaskString> tasksId) {
        this.theoryTasksId = tasksId;
    }

    public ArrayList<TaskString> getTheoryTasksId() {
        return this.theoryTasksId;
    }

    @Override
    public String toString() {
        String practicTaskString = new String();
        String theoryTaskString = new String();
        for (Iterator<TaskString> i = this.practicTasksId.iterator(); i.hasNext();) {
            practicTaskString += i.next().getTaskID();
            practicTaskString += ", ";
        }
        for (Iterator<TaskString> i = this.theoryTasksId.iterator(); i.hasNext();) {
            theoryTaskString += i.next().getTaskID();
            theoryTaskString += ", ";
        }
        return "student id: " + studentId + ", course id: " + courseId + " theory tasks: "+ theoryTaskString+ " practic tasks: "+ practicTaskString;
    }

}
