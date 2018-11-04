package com.schibsted.dirfinder.directories;

import java.io.File;
import java.io.FileNotFoundException;

public interface FileWords {

    Integer getPercentOcurrsOneWord(String word);

    void loadFile(File file) throws FileNotFoundException;
}
