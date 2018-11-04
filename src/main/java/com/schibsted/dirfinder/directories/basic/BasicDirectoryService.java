package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.Directory;
import com.schibsted.dirfinder.directories.DirectorySearch;
import com.schibsted.dirfinder.directories.DirectoryService;

public class BasicDirectoryService implements DirectoryService {

    private Directory directory;

    public BasicDirectoryService( Directory directory){
        this.directory = directory;
    }

    public Directory scanDirectory(String directoryPath) {
        directory.setPathDirectory(directoryPath);
        System.out.println(directory.getNumberReadFiles() + " files read in directory " + directory.getPath());
        return directory;
    }

    public DirectorySearch findWord(String line) {
        return directory.findWordsInDirectory(line);
    }
}
