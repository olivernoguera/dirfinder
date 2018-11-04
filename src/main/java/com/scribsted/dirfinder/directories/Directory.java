package com.scribsted.dirfinder.directories;

import java.io.File;

public interface Directory {

    File[] getFiles();

    String getPath();

    void setPathDirectory(String directoryPath);

}

