package com.codurance.training.tasks;

import com.codurance.training.tasks.services.ViewByProjectService;
import com.codurance.training.tasks.services.TaskListService;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class ViewByProject implements TaskListService, ViewByProjectService {

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

}
