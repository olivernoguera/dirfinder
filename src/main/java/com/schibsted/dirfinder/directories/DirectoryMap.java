package com.schibsted.dirfinder.directories;

import java.io.File;

public interface DirectoryMap {

    void load(File directory);

    DirectorySearch findWordsInDirectory(String line);

    Integer filesScanned();

}
