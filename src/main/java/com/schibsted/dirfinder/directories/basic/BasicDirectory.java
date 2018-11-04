package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.Directory;
import com.schibsted.dirfinder.directories.DirectoryMap;
import com.schibsted.dirfinder.directories.DirectorySearch;

import java.io.File;

public class BasicDirectory implements Directory {

    private File directory;
    private DirectoryMap directoryMap;

    public void setPathDirectory(String directoryPath) {
        directory = new File(directoryPath);
        if (!directory.canRead()) {
            throw new IllegalArgumentException(" Path can not read");
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(" Path is not a directory");
        }
        this.directoryMap = new BasicDirectoryMap();
        directoryMap.load(directory);
    }

    @Override
    public DirectorySearch findWordsInDirectory(String line) {
        return directoryMap.findWordsInDirectory(line);
    }

    public Integer getNumberReadFiles() {
        return directoryMap.filesScanned();
    }

    public String getPath() {
        return directory.getPath();
    }
}
