/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Elena_Kholkina
 */
public class Task {

   

    public enum TaskState {

        LEARNING_NOT_BEGIN, LEARNING_IN_PROCESS, LEARNING_ENDED, MAKING_NOT_BEGIN, MAKING_IN_PROCESS, EXERCISE_CHEKING, EXERCISES_DONE
    };

    public enum TaskType {

        PRACTIC_TASK, THEORY_TASK
    };
    int id;
    private String title;
    private int duration;
    private TaskType type;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
    }

     public Task() {
       
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public TaskType getType() {
        return this.type;
    }
    @Override
    public String toString(){
return "id: "+id+" title: "+ title+ " duration: "+ duration + " type "+ type;}
}
