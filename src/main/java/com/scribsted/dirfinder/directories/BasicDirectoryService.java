package com.scribsted.dirfinder.directories;

import java.io.File;

public class BasicDirectoryService implements DirectoryService {

    private Directory directory;

    public BasicDirectoryService( Directory directory){
        this.directory = directory;
    }

    public Directory scanDirectory(String directoryPath) {
        directory.setPathDirectory(directoryPath);
        File[] files = directory.getFiles();
        System.out.println(files.length + " files read in directory " + directory.getPath());
        return directory;
    }
}
