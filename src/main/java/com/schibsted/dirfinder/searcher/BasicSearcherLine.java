package com.schibsted.dirfinder.searcher;

import com.schibsted.dirfinder.directories.DirectorySearch;
import com.schibsted.dirfinder.directories.DirectoryService;

import java.io.InputStream;
import java.util.Scanner;

public class BasicSearcherLine  implements SearcherLine {

    private Scanner keyboard;
    private DirectoryService directoryService;

    public BasicSearcherLine(InputStream keyboard, DirectoryService directoryService) {
        this.keyboard = new Scanner(keyboard);
        this.directoryService = directoryService;
    }

    public void scan(){
        while (true) {
            System.out.print("search> ");
            final String line = keyboard.nextLine();
            if( line.equals(END_TOKEN)){
                break;
            }
            DirectorySearch directorySearch = directoryService.findWord(line);
            System.out.println(directorySearch);
        }
    }

}
