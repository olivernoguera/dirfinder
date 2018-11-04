package com.schibsted.dirfinder.directories;

public interface DirectoryService {

    Directory scanDirectory(String path);

    DirectorySearch findWord(String line);
}
