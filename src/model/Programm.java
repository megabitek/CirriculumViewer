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
public class Programm {

    private int id;
    private String title;
    private String author;
    private Date creationDate;
    private ArrayList<Integer> courses;
    private ArrayList<Course> coursesObbjects;

    /* public Programm(int id, String title, String author, Date creationDate, int[] course) {
     this.id = id;
     this.title = title;
     this.author = author;
     this.creationDate = creationDate;
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

    public void setCourses(ArrayList<Integer> courses) {
        this.courses = courses;
    }

    public ArrayList<Integer> getCourses() {
        return this.courses;
    }

    public void setCoursesObjects(ArrayList<Course> course) {
        this.coursesObbjects = course;
    }

    public ArrayList<Course> getCoursesObjects() {
        return this.coursesObbjects;
    }

 
    public String getDescription() {
        String courseString = new String();
        for (Iterator<Course> i = this.coursesObbjects.listIterator(); i.hasNext();) {
            courseString += i.next().getTitle();
            courseString += ",\n ";
        }
        return "id: " + id + ", \n title:" + title + ", \n author: " + author + " \n date: " + creationDate + " \n course:" + courseString;
    }
    @Override
    public String toString (){
        return this.title;
    }
}
