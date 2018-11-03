package com.scribsted.dirfinder;

import java.io.File;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No directory given to index.");
        }

        final File indexableDirectory = new File(args[0]);

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
