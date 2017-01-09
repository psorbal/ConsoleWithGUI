package com.console.application.commands.filters;

import java.io.File;
import java.io.FilenameFilter;

public class ExtFilter implements FilenameFilter {
    private String ext;

    public ExtFilter(String ext){
        this.ext = ext;
    }

    public boolean accept(File file, String name) {
        return name.endsWith(ext);
    }
}
