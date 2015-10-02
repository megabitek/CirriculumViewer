/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Elena_Kholkina
 */
public class Student {

    private int id;
    private String fullName;
    private String city;
    private String eMail;
    private boolean contract;
    private Date learningBeginDate;
    private int programmid;
    private Programm programmObject;

    public Student() {
    }

    public Student(int id, String fullName, int programmid) {
        this.id = id;
        this.fullName = fullName;
        this.programmid = programmid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getEmail() {
        return this.eMail;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }

    public boolean getContract() {
        return this.contract;
    }

    public void setLearningBeginDate(Date learningBeginDate) {
        this.learningBeginDate = learningBeginDate;
    }

    public Date getLearningBeginDate() {
        return learningBeginDate;
    }

    public void setProgrammId(int programmId) {
        this.programmid = programmId;
    }
      public int getProgrammId() {
        return this.programmid;
    }
      
      public void setProgrammObject(Programm programm) {
        this.programmObject = programm;
    }
      public Programm getProgrammObject() {
        return this.programmObject;
    }
    @Override
    public String toString(){
        return this.fullName;
    }
    public String getDescription(){
        return "id: "+id+ ",\n Name:"+ fullName+",\n e-mail: "+ eMail+ ",\n date learning begin: "+ learningBeginDate + ",\n contract: "+ contract+ ",\n programm: " + this.programmObject.getTitle();
    }
}

