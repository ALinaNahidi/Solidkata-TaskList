package com.codurance.training.tasks;

import com.codurance.training.tasks.services.HelpService;

import static java.lang.System.out;

public class Help implements HelpService {
    @Override
    public void help() {
        out.println("Commands:");
        out.println("  view by project");
        out.println("  today");
        out.println("  view by deadline");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println("  deadline <ID> <date>");
        out.println("  delete <ID>");
        out.println("  customize <ID> <CustomizedID>");
        out.println();
    }
}
