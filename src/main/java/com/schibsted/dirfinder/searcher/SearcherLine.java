package com.schibsted.dirfinder.searcher;

public interface SearcherLine {

    String END_TOKEN = ":quit";

    void scan();
}
