package com.codurance.training.tasks;

import com.codurance.training.tasks.services.TaskListService;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Deadline implements TaskListService {
    private final Date deadline;

    private final String id;


    public Deadline(String id, Date deadline) {
        this.deadline = deadline;
        this.id = id;
    }

    public void addDeadline(){
        int flag=0;
        for (List<Task> list : tasks.values()){
            for(Task values: list){
                if(Objects.equals(values.getId(), id)){
                    values.setDeadline(deadline);
                    flag=1;
                }
                if(flag==1)break;
            }
            if(flag==1)break;
        }
        if(flag==0) System.out.println("task with ID:" + id +" is not found");
    }


}
