package com.scribsted.dirfinder.directories;

public interface DirectoryService {

    Directory scanDirectory(String path);

    void findWord(String line);
}
