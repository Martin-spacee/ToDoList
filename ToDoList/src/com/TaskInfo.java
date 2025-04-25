package com;


import java.io.Serializable;
import java.util.Date;

public class TaskInfo implements Serializable {
    private boolean isDone;
    private final int id;
    private String nameOfTask;
    private String commentOfTask;
    private Date date;

    public TaskInfo(boolean isDone, int id, String nameOfTask, String commentOfTask, Date date) {
        this.isDone = isDone;
        this.id = id;
        this.commentOfTask = commentOfTask;
        this.nameOfTask = nameOfTask;
        this.date = date;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public void setCommentOfTask(String commentOfTask) {
        this.commentOfTask = commentOfTask;
    }

    public String getDate() {
        return TaskManager.formatter.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
