package com.codurance.training.tasks;

import com.codurance.training.tasks.services.TaskListService;
import com.codurance.training.tasks.services.ViewByDateService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ViewByDate implements ViewByDateService, TaskListService {
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
