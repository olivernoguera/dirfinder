package com.schibsted.dirfinder.searcher;

import com.schibsted.dirfinder.directories.Directory;
import com.schibsted.dirfinder.directories.DirectoryService;
import com.schibsted.dirfinder.directories.basic.BasicDirectory;
import com.schibsted.dirfinder.directories.basic.BasicDirectoryService;
import com.schibsted.dirfinder.inputreader.ArgumentsReader;
import com.schibsted.dirfinder.inputreader.BasicArgumentsReader;

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