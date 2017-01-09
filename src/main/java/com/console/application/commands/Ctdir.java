package com.console.application.commands;

/**
 * Class for command ctdir which allow to crate new folder
 */

import com.console.application.parameter.Observer;
import com.console.application.parameter.Parameter;
import java.io.File;

public class Ctdir implements Command, Observer {
    private Parameter parameter;
    private String nameOfNewDirectory;
    private String path;

    public Ctdir(Parameter parameter){
        this.parameter = parameter;
        parameter.addObserver(this);
        this.path = parameter.getPath();
    }

    public boolean matches(String command) {
        if (command.matches("ctdir (.+)")){
            this.nameOfNewDirectory = command.substring(6);
            return true;
        }
        else return false;
    }

    public String executeCommand() {
        File file = new File(path+"/"+nameOfNewDirectory);
        if(!file.exists()) {
            if (file.mkdir()) {
                return "Directory "+nameOfNewDirectory+ " is created!\n";
            } else {
                return "Failed to create "+nameOfNewDirectory+" directory!\n";
            }
        }
        return nameOfNewDirectory + " directory exists in this current working directory\n";
    }

    public void update() {
        this.path = parameter.getPath();
    }
}
