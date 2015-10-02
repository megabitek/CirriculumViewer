/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Elena_Kholkina
 */
public class Course {

    private int id;
    private String title;
    private String author;
    private Date creationDate;
    private ArrayList<Integer> practicTasks;
    private ArrayList<Task> practicTasksObjects;
    private ArrayList<Integer> theoryTasks;
    private ArrayList<Task> theoryTasksObjects;

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Course() {

    }

    /* public Course(int id, String title, String author, Date creationDate,ArrayList<Integer>  tasks) {
     this.id = id;
     this.title = title;
     this.author = author;
     this.creationDate = creationDate;
     this.tasks = tasks;
     }*/
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setTheoryTasks(ArrayList<Integer> tasks) {
        this.theoryTasks = tasks;
    }

    public ArrayList<Integer> getTheoryTasks() {
        return this.theoryTasks;
    }

    public void setPracticTasks(ArrayList<Integer> tasks) {
        this.practicTasks = tasks;
    }

    public ArrayList<Integer> getPracticTasks() {
        return this.practicTasks;
    }

    public void setTheoryTasksObjects(ArrayList<Task> tasks) {
        this.theoryTasksObjects = tasks;
    }

    public ArrayList<Task> getTheoryTasksObjects() {
        return this.theoryTasksObjects;
    }

    public void setPracticTasksObjects(ArrayList<Task> tasks) {
        this.practicTasksObjects = tasks;
    }

    public ArrayList<Task> getPracticTasksObjects() {
        return this.practicTasksObjects;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public String getDescription() {
        String practicTasksStr = new String();
        String theoryTasksStr = new String();
        for (Iterator<Task> i = this.practicTasksObjects.iterator(); i.hasNext();) {
            practicTasksStr += i.next().getTitle();
            practicTasksStr += ", \n";
        }
        for (Iterator<Task> i = this.theoryTasksObjects.iterator(); i.hasNext();) {
            theoryTasksStr += i.next().getTitle();
            practicTasksStr += ", \n ";
        }

        return "id: " + id + "\n  title: " + title + "\n author: " + author + "\n theory task:" + theoryTasksStr + "\n practic task: " + practicTasksStr;
        
    }
}
