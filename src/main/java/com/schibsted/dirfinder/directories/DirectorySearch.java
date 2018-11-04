package com.schibsted.dirfinder.directories;

import java.util.Set;

public interface DirectorySearch  {

    void append(DirectorySearchToken directorySearchToken);

    Set<DirectorySearchToken> getTokens();


}