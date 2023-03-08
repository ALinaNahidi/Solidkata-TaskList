package com.codurance.training.tasks;

import com.codurance.training.tasks.services.ViewService;
import com.codurance.training.tasks.services.TaskListService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.lang.System.out;

public class View implements TaskListService, ViewService {

    @Override
    public void show() {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }

    @Override
    public void viewToday(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateToday = new Date();
        for (List<Task> list : tasks.values()){
            for(Task values: list){
                if(values.getDeadline()!= null && format.format(values.getDeadline()).equals(format.format(dateToday)) && !values.isDone()){
                    System.out.println(values.getId()+ " "+ values.getDeadline());
                }
            }
        }
    }

    @Override
    public void viewByDeadline(Date deadline){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (List<Task> list : tasks.values()){
            for(Task values: list){
                if(values.getDeadline()!= null && Objects.equals(format.format(values.getDeadline()), format.format(deadline))){
                    System.out.println(values.getId()+ " "+ values.getDeadline());
                }
            }
        }
    }

    @Override
    public void viewByDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (List<Task> list : tasks.values()){
            for(Task values: list){
                if(Objects.equals(format.format(values.getCreatedAt()), format.format(date))){
                    System.out.println(values.getId()+ " "+ values.getCreatedAt());
                }
            }
        }
    }
}
