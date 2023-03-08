package com.codurance.training.tasks;

import com.codurance.training.tasks.services.CustomizeService;
import com.codurance.training.tasks.services.TaskListService;

import java.util.List;
import java.util.Objects;

public class Customize implements CustomizeService, TaskListService {

    private final String defaultId;
    private final String customisedId;

    public Customize(String defaultId, String customisedId) {
        this.defaultId = defaultId;
        this.customisedId = customisedId;
    }

    @Override
    public void customizeID() {
        int flag = 0;
        for (List<Task> list : tasks.values()){
            for(Task value: list){
                if(Objects.equals(value.getId(), defaultId)){
                    if(customisedId.matches("^[a-zA-Z0-9]+$")){
                        value.setId(customisedId);
                    }
                    else{
                        System.out.println("invalid ID");
                    }
                    flag=1;
                    break;
                }
            }
            if(flag==1) break;
        }
        if(flag==0) System.out.println("No task with ID: "+ defaultId);
    }

}
