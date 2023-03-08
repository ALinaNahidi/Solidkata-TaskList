package com.codurance.training.tasks;

import com.codurance.training.tasks.services.AddProjectService;
import com.codurance.training.tasks.services.TaskListService;

import java.util.ArrayList;
public class AddProject implements AddProjectService, TaskListService {

    private final String name;
    public AddProject(String name){
        this.name = name;
    }

    @Override
    public void addProject() {
        tasks.put(name, new ArrayList<Task>());
    }
}
