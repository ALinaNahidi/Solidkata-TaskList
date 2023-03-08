package com.codurance.training.tasks;

import com.codurance.training.tasks.services.TaskListService;
import com.codurance.training.tasks.services.ViewByDeadlineService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ViewByDeadline implements ViewByDeadlineService, TaskListService {
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
}
