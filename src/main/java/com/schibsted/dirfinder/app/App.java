package com.schibsted.dirfinder.app;

import com.schibsted.dirfinder.searcher.BasicSearcher;
import com.schibsted.dirfinder.searcher.Searcher;

public class App {

    public static void main(String[] args) {

        Searcher searcher = new BasicSearcher();
        searcher.run(args);
    }
}