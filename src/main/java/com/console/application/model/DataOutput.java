package com.console.application.model;

import com.console.application.commands.*;
import com.console.application.parameter.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for interactive console application
 */

public class DataOutput{
    private Parameter parameter = new Parameter();
    private List<Command> activeCommand = new ArrayList<>();
    private boolean matchFound = false;

    public String exec(String userCommand){
        StringBuilder sb = new StringBuilder();
        activeCommand.add(new Dir(parameter));
        activeCommand.add(new Tree(parameter));
        activeCommand.add(new Cd(parameter));
        activeCommand.add(new Ctdir(parameter));
        activeCommand.add(new Ctfile(parameter));
        activeCommand.add(new Delete(parameter));

        for (Command command : activeCommand) {
            if (command.matches(userCommand)) {
                matchFound = true;
                sb.append(command.executeCommand());
                break; //handle the first matching command only
            }
        }

        if (!matchFound) {
            sb.append(userCommand);
            sb.append(": unknown command \n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
