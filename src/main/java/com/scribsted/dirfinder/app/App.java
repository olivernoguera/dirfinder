package com.scribsted.dirfinder.app;

import com.scribsted.dirfinder.searcher.BasicSearcher;
import com.scribsted.dirfinder.searcher.Searcher;

public class App {

    public static void main(String[] args) {

        Searcher searcher = new BasicSearcher();
        searcher.run(args);
    }
}