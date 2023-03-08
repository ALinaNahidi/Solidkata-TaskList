package com.codurance.training.tasks;

import com.codurance.training.tasks.services.ErrorService;

import static java.lang.System.out;

public class Error implements ErrorService {

    private final String command;

    public Error(String command)
    {
        this.command = command;
    }

    @Override
    public void error() {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}
