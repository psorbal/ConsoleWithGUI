package com.console.application.commands.filters;

import java.io.File;
import java.io.FilenameFilter;

public class RegFilter implements FilenameFilter{
    private String reg;

    public RegFilter(String startsWith){
        this.reg = startsWith.substring(0, startsWith.length()-1);
    }

    public boolean accept(File file, String name) {
        return name.startsWith(reg);
    }
}