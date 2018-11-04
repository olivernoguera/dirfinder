package com.schibsted.dirfinder.inputreader;

public class BasicArgumentsReader  implements ArgumentsReader{

    public String readArguments(String[] args){
        if (args == null || args.length == 0){
            throw new IllegalArgumentException("No directory given to index.");
        }
        String directory = args[0];
        System.out.println("Reading on directory " + directory);
        return directory;
    }
}
