package com;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        TaskInfo info = new TaskInfo(false, 1, "Java", "Закрыть дз", new Date());
        TaskInfo info2 = new TaskInfo(false, 2, "СИАОД", "Сделать 2 практику", new Date());
        TaskInfo info3 = new TaskInfo(false, 3, "СИИБД", "Закрыть 5,6 практики", new Date());
        TaskInfo info4 = new TaskInfo(false, 4, "Матан", "Закрыть дз", new Date());
        TaskInfo info5 = new TaskInfo(false, 5, "Линал", "Закрыть дз", new Date());

        TaskManager manager = new TaskManager();
        manager.addTask(info);
        manager.addTask(info2);
        manager.addTask(info3);
        manager.addTask(info4);
        manager.addTask(info5);

        manager.writeTasks();
        manager.showTasks();
        manager.loadTasks();
        manager.showTasks();
    }
}