package com.scribsted.dirfinder.directories;

import java.io.File;

public class BasicDirectory implements Directory {

    private File directory;

    public void setPathDirectory(String directoryPath){
        directory = new File(directoryPath);
        if( !directory.canRead() ){
            throw new IllegalArgumentException(" Path can not read");
        }
        if( !directory.isDirectory()){
            throw new IllegalArgumentException(" Path is not a directory");
        }
    }

    public File[] getFiles() {
        return directory.listFiles();
    }

    public String getPath() {
        return directory.getPath();
    }
}
