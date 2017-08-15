package com.console.application.commands;

import com.console.application.commands.filters.ExtFilter;
import com.console.application.commands.filters.RegFilter;
import com.console.application.parameter.Observer;
import com.console.application.parameter.Parameter;

import java.io.File;

public class Delete implements Command, Observer {
    private Parameter parameter;
    private String path;
    private String nameOfFile;

    public Delete(Parameter parameter){
        this.parameter = parameter;
        parameter.addObserver(this);
        this.path = parameter.getPath();
    }

    public boolean matches(String command) {
        if (command.matches("delete (.+)")){
            this.nameOfFile = command.substring(7);
            return true;
        } else {
            return false;
        }
    }

    public String executeCommand() {
        if (nameOfFile.matches("all")){
            return deleteAllFiles();
        } else if(nameOfFile.matches("(.+)\\*")){
            return deleteFileWithRegex();
        } else if (nameOfFile.matches("\\..+")){
            return deleteFilesWithExtension();
        } else {
            return deleteFileFullName();
        }
    }

    public void update() {
        this.path = parameter.getPath();
    }

    private String deleteAllFiles(){
        File [] files = new File(path).listFiles();
        return deleteOperationFromListFiles(files).toString();
    }

    private String deleteFilesWithExtension(){
        ExtFilter filter = new ExtFilter(nameOfFile);
        File [] files = new File(path).listFiles(filter);
        return deleteOperationFromListFiles(files).toString();
    }

    private String deleteFileWithRegex(){
        RegFilter regFilter = new RegFilter(nameOfFile);
        File [] files = new File(path).listFiles(regFilter);
        return deleteOperationFromListFiles(files).toString();
    }

    private String deleteFileFullName(){
        File file = new File(path+"/"+nameOfFile);
        if (file.delete()){
            return nameOfFile + " is deleted\n";
        } else {
            return "Delete operation has failed\n";
        }
    }

    private StringBuilder deleteOperationFromListFiles(File[] files){
        StringBuilder sb = new StringBuilder();
        if (files != null) {
            for (File f : files) {
                if (f.delete()) {
                    sb.append(f.getName());
                    sb.append(" is deleted\n");
                } else {
                    sb.append(f.getName());
                    sb.append(" - delete operation has failed\n");
                }
            }
        } else {
            sb.append("There is no files to delete");
        }

        return sb;
    }
}
