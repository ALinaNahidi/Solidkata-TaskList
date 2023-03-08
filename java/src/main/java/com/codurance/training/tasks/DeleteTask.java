package com.codurance.training.tasks;

import com.codurance.training.tasks.services.TaskListService;

import java.util.List;
import java.util.Objects;

public class DeleteTask implements TaskListService {

    private final String taskID;

    public DeleteTask(String taskID) {
        this.taskID = taskID;
    }

    public void deleteTask(){
        int flag=0;
        for (List<Task> list : tasks.values()){
            for(Task values: list){
                if(Objects.equals(values.getId(), taskID)){
                    list.remove(values);
                    flag=1;
                }
                if(flag==1)break;
            }
            if(flag==1)break;
        }
        if(flag==0) System.out.println("task with ID:" + taskID +" is not found");
    }
}
