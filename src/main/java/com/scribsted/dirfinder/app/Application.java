package com.scribsted.dirfinder.app;

import com.scribsted.dirfinder.inputreader.ArgumentsReader;
import com.scribsted.dirfinder.inputreader.BasicArgumentsReader;

import java.io.File;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        ArgumentsReader argumentsReader = new BasicArgumentsReader();
        String directory = argumentsReader.readArguments(args);
        final File indexableDirectory = new File(directory);

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
