package com.console.application.commands;

import com.console.application.parameter.Observer;
import com.console.application.parameter.Parameter;

import java.io.File;

/**
 * Class for dir command.
 * User can display the content of current working directory using a ‘dir’ command.
 * Format of the display: type of the item (DIR|FILE) and name of the item.
 * Example:
 * DIR      classes
 * FILE     pom.xml
 */

public class Dir implements Command, Observer {
    private Parameter parameter;
    private String path;

    public Dir(Parameter parameter){
        this.parameter = parameter;
        parameter.addObserver(this);
        this.path = parameter.getPath();
    }

    public boolean matches(String command) {
        return command.matches("dir");
    }

    public String executeCommand() {
        StringBuilder sb = new StringBuilder();
        try {
            File [] files = new File(path).listFiles();

            if (files != null && files.length != 0) {
                sb.append("Content of ");
                sb.append(path);
                sb.append("\n");
                for (File f : files) {
                    if (f.isDirectory()) {
                        sb.append("DIR \t\t");
                        sb.append(f.getName());
                        sb.append("\n");
                    } else {
                        sb.append("FILE \t\t");
                        sb.append(f.getName());
                        sb.append("\n");
                    }
                }
            } else {
                return "This folder is empty \n";
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return sb.toString();
    }

    public void update() {
        this.path = parameter.getPath();
    }
}
