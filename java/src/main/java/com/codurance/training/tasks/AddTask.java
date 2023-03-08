package com.codurance.training.tasks;

import com.codurance.training.tasks.services.AddTaskService;
import com.codurance.training.tasks.services.TaskListService;

import java.util.List;

import static java.lang.System.out;

public class AddTask implements AddTaskService, TaskListService {

    private final String project;
    private final String description;
    private String lastId;

    public AddTask(String project, String description,String lastId){
        this.description = description;
        this.project = project;
        this.lastId = lastId;
    }

    @Override
    public void addtask() {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(lastId, description, false));
    }

}

