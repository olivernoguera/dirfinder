package com.schibsted.dirfinder.directories;

import java.util.Set;

public interface DirectorySearch extends Comparable<DirectorySearchToken> {

    void append(DirectorySearchToken directorySearchToken);

    Set<DirectorySearchToken> getTokens();


}