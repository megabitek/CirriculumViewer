/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
    private ArrayList<Integer> theoryTasks; 

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

    public void setTheoryTasks( ArrayList<Integer>  tasks) {
        this.theoryTasks = tasks;
    }

    public  ArrayList<Integer> getTheoryTasks() {
        return this.theoryTasks;
    }
    public void setPracticTasks( ArrayList<Integer>  tasks) {
        this.practicTasks = tasks;
    }

    public  ArrayList<Integer> getPracticTasks() {
        return this.practicTasks;
    } 
    @Override
    public String toString (){
    String practicTasksStr = new String();
    String theoryTasksStr = new String();
    for (Iterator i= this.practicTasks.iterator(); i.hasNext();)
    {
    practicTasksStr +=i.next();
    practicTasksStr+=", ";}
     for (Iterator i= this.theoryTasks.iterator(); i.hasNext();)
    {
    theoryTasksStr +=i.next();
    practicTasksStr+=", ";}
     
     return "id: "+ id+  " title: "+ title+ " author: "+author + " theory task:"+ theoryTasksStr+ " practic task: "+ practicTasksStr;}
}
