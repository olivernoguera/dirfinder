package com.schibsted.dirfinder.directories;

import java.util.List;

public interface DirectorySearch {

    void append(DirectorySearchToken directorySearchToken);

    List<DirectorySearchToken> getTokens();


}