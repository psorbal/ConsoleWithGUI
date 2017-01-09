package com.console.application.commands;

public interface Command {
    boolean matches(String command);
    String executeCommand();
}
