package com.schibsted.dirfinder.directories;

public interface Directory {

    String getPath();

    void setPathDirectory(String directoryPath);

    DirectorySearch findWordsInDirectory(String line);

    Integer getNumberReadFiles();

}

