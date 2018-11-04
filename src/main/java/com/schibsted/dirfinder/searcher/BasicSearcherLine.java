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
        boolean quit = false;
        while (!quit) {
            System.out.print("search> ");
            final String line = keyboard.nextLine();
            if( line.equals(END_TOKEN)){
                quit = true;
                continue;
            }
            DirectorySearch directorySearch = directoryService.findWord(line);
            if( directorySearch.getTokens().isEmpty()){
                System.out.print(line + " ");
            }
            System.out.println(directorySearch);

        }
    }

}
