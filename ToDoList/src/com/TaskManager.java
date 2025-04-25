package com;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class TaskManager {
    private ArrayList<TaskInfo> tasks = new ArrayList<>();
    static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public void addTask(TaskInfo info) {
        tasks.add(info);
    }

    public void showTasks() {
        if(!tasks.isEmpty()) {
            for (TaskInfo info : tasks) {
                System.out.println(info.getId() + " " + info.getNameOfTask() + " " + info.getDate() + " " + info.isDone());
            }
        }
        else System.out.println("Задачи были загружены в файл. Задачник пуст");
    }

    public void editTask(int id) throws ParseException {
        TaskInfo task = null;
        for(TaskInfo tsk: tasks) {

            if(id == tsk.getId()){
                task = tsk;
                break;
            }
        }
        if(task != null){
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "1. Изменить статус\n" +
                    "2. Название\n" +
                    "3. Комментарий\n" +
                    "4. Дату");

            int whatWeEdit = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Напишите новое значение: ");

            switch (whatWeEdit) {

                case 1:
                    boolean isDone = scanner.nextBoolean();
                    scanner.nextLine();
                    task.setDone(isDone);
                    break;

                case 2:
                    String nameOfTask = scanner.nextLine();
                    task.setNameOfTask(nameOfTask);
                    break;

                case 3:
                    String commentOfTask = scanner.nextLine();
                    task.setCommentOfTask(commentOfTask);
                    break;

                case 4:
                    String date = scanner.nextLine();
                    task.setDate(formatter.parse(date));
                    break;
                default:
                    System.out.println("Не нашли такой параметр");

            }
        }

        else System.out.println("Задача с таким id нет");
    }

    public void deleteTask(int id) {
        Iterator<TaskInfo> iterator = tasks.iterator();

        while (iterator.hasNext()) {
            TaskInfo task = iterator.next();

            if(task.getId() == id){
                iterator.remove();
                break;
            }
        }
    }

    public void writeTasks() throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tasks.dat"))) {
            oos.writeObject(tasks);
            tasks.clear();
        }
    }
    public void loadTasks() throws IOException, ClassNotFoundException {
        if(!tasks.isEmpty()) {
            System.out.println("Загрузка невозможна. Сначала сохраните текущие задачи.");
            return;
        }

        try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream("tasks.dat"))) {
            tasks = (ArrayList<TaskInfo>) oos.readObject();
        }
    }

}
