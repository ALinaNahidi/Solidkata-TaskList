package com.codurance.training.tasks;

import com.codurance.training.tasks.services.CheckService;
import com.codurance.training.tasks.services.TaskListService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.lang.System.out;

public class Check implements CheckService, TaskListService {

    private final String idString;

    public Check(String idString){
        this.idString = idString;
    }

    @Override
    public void check() {
        setDone(idString, true);
    }

    @Override
    public void uncheck() {
        setDone(idString, false);
    }

    private void setDone(String idString, boolean done) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (Objects.equals(task.getId(), idString)) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %s.", idString);
        out.println();
    }
}
