/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Task.TaskState;

/**
 *
 * @author Elena_Kholkina
 */
public class TaskString {

    private int taskid;
    private TaskState taskState;
    private int balls;

    public TaskString() {
    }

    public void setTaskID(int taskid) {
        this.taskid = taskid;
    }

    public int getTaskID() {
        return this.taskid;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    public TaskState getTaskState() {
        return this.taskState;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getBalls() {
        return this.balls;
    }
}
