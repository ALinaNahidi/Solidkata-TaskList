package com.codurance.training.tasks;

import com.codurance.training.tasks.services.CheckService;
import com.codurance.training.tasks.services.CustomizeService;
import com.codurance.training.tasks.services.ErrorService;
import com.codurance.training.tasks.services.HelpService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";
    private long lastId = 0;
    private final BufferedReader in;
    private final PrintWriter out;



    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            try {
                execute(command);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void execute(String commandLine) throws ParseException {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "add" -> {
                String[] subcommandRest = commandRest[1].split(" ", 2);
                String subcommand = subcommandRest[0];
                if (subcommand.equals("project")) {
                    AddProject addProject = new AddProject(subcommandRest[1]);
                    addProject.addProject();
                } else if (subcommand.equals("task")) {
                    String[] projectTask = subcommandRest[1].split(" ", 2);
                    AddTask addTask = new AddTask(projectTask[0], projectTask[1], Long.toString(nextId()));
                    addTask.addtask();
                }
            }
            case "check" -> {
                CheckService checkServiceCheck = new Check(commandRest[1]);
                checkServiceCheck.check();
            }
            case "uncheck" -> {
                CheckService checkServiceUncheck = new Check(commandRest[1]);
                checkServiceUncheck.uncheck();
            }
            case "help" -> {
                HelpService help = new Help();
                help.help();
            }
            case "deadline" -> {
                String[] subCommandLine = commandRest[1].split(" ");
                Deadline deadline = new Deadline(subCommandLine[0], new SimpleDateFormat("dd/MM/yyyy").parse(subCommandLine[1]));
                deadline.addDeadline();
            }
            case "today" -> {
                View viewToday = new View();
                viewToday.viewToday();
            }
            case "view" -> {
                String[] subCommand = commandRest[1].split(" ");
                if (Objects.equals(subCommand[1], "project")) {
                    View show = new View();
                    show.show();
                } else if (Objects.equals(subCommand[1], "deadline")) {
                    View view = new View();
                    Date viewDate = new SimpleDateFormat("dd/MM/yyyy").parse(commandLine.split(" ")[3]);
                    view.viewByDeadline(viewDate);
                } else if (Objects.equals(subCommand[1], "date")) {
                    View view = new View();
                    Date viewDate = new SimpleDateFormat("dd/MM/yyyy").parse(commandLine.split(" ")[3]);
                    view.viewByDate(viewDate);
                }
            }
            case "delete" -> {
                DeleteTask deleteTask = new DeleteTask(commandRest[1]);
                deleteTask.deleteTask();
            }
            case "customize" -> {
                String[] ids = commandRest[1].split(" ");
                CustomizeService customizeService = new Customize(ids[0], ids[1]);
                customizeService.customizeID();
            }
            default -> {
                ErrorService errorService = new Error(command);
                errorService.error();
            }
        }


    }

    private long nextId() {
        return ++lastId;
    }

}
