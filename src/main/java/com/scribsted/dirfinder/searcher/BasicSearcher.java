package com.scribsted.dirfinder.searcher;

import com.scribsted.dirfinder.directories.BasicDirectory;
import com.scribsted.dirfinder.directories.BasicDirectoryService;
import com.scribsted.dirfinder.directories.Directory;
import com.scribsted.dirfinder.directories.DirectoryService;
import com.scribsted.dirfinder.inputreader.ArgumentsReader;
import com.scribsted.dirfinder.inputreader.BasicArgumentsReader;

public class BasicSearcher implements Searcher {

    private ArgumentsReader argumentsReader;
    private Directory directory;
    private DirectoryService directoryService;
    private SearcherLine searcherLine;

    public void run(String[] args) {

        this.argumentsReader = new BasicArgumentsReader();
        this.directory = new BasicDirectory();

        String pathDirectory = argumentsReader.readArguments(args);

        directoryService = new BasicDirectoryService(directory);
        directory = directoryService.scanDirectory(pathDirectory);

        searcherLine = new BasicSearcherLine(System.in, directoryService);
        searcherLine.scan();

    }

}