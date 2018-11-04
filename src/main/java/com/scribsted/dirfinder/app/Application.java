package com.scribsted.dirfinder.app;

import com.scribsted.dirfinder.directories.BasicDirectory;
import com.scribsted.dirfinder.directories.BasicDirectoryService;
import com.scribsted.dirfinder.directories.Directory;
import com.scribsted.dirfinder.directories.DirectoryService;
import com.scribsted.dirfinder.inputreader.ArgumentsReader;
import com.scribsted.dirfinder.inputreader.BasicArgumentsReader;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        ArgumentsReader argumentsReader = new BasicArgumentsReader();
        String directoryPath = argumentsReader.readArguments(args);

        Directory directory = new BasicDirectory();
        DirectoryService directoryService = new BasicDirectoryService(directory);
        directoryService.scannDirectory(directoryPath);
        //TODO: Index all files in indexableDirectory
        Scanner keyboard = new Scanner(System.in);

        while (true) {

            System.out.print("search> ");
            final String line = keyboard.nextLine();
            //TODO: Search indexed files for words in line
            System.out.println(line);

        }
    }
}
