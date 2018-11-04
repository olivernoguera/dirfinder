package com.scribsted.dirfinder.directories;

public class BasicDirectoryService implements DirectoryService {

    private final String directory;

    public BasicDirectoryService(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }

    public String scannDirectory() {
        return null;
    }
}
