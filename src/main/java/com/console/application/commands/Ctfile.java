package com.console.application.commands;

import com.console.application.parameter.Observer;
import com.console.application.parameter.Parameter;

import java.io.File;
import java.io.IOException;

/**
 * Class for command ctfile which allow create new file
 */

public class Ctfile implements Command, Observer {
    private Parameter parameter;
    private String nameOfNewFile;
    private String path;

    public Ctfile(Parameter parameter){
        this.parameter = parameter;
        parameter.addObserver(this);
        this.path = parameter.getPath();
    }

    public boolean matches(String command) {
        if (command.matches("ctfile (.+)")){
            this.nameOfNewFile = command.substring(7);
            return true;
        }
        else return false;
    }

    public String executeCommand() {
        String output = null;
        try {
            File file = new File(path+"/"+nameOfNewFile);
            if(file.createNewFile()){
                output = nameOfNewFile + " is created \n";
            }
            else {
                output = nameOfNewFile + " already exists\n";
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return output;
    }

    public void update() {
        this.path = parameter.getPath();
    }
}
