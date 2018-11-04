package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.DirectorySearch;
import com.schibsted.dirfinder.directories.DirectorySearchToken;

import java.util.Set;
import java.util.TreeSet;

public class BasicDirectorySearch implements DirectorySearch {

    private Set<DirectorySearchToken> files = new TreeSet();


    public void append(DirectorySearchToken directorySearchToken) {
        files.add(directorySearchToken);
    }

    @Override
    public String toString(){
        final StringBuilder stringBuilder = new StringBuilder();
        if( files.isEmpty()){
            return "no matches found";
        }
        int i = 0;
        for(DirectorySearchToken directorySearchToken: files){
            stringBuilder.append(directorySearchToken);
            if ((i +1) < files.size()){
                stringBuilder.append(" ");
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public Set<DirectorySearchToken> getTokens(){
        return files;
    }
}
