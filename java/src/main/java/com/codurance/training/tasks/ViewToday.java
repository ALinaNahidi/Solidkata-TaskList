package com.codurance.training.tasks;

import com.codurance.training.tasks.services.TaskListService;
import com.codurance.training.tasks.services.ViewTodayService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ViewToday implements ViewTodayService, TaskListService {
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
}
