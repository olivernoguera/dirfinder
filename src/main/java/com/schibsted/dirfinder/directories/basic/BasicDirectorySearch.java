package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.DirectorySearch;
import com.schibsted.dirfinder.directories.DirectorySearchToken;

import java.util.Set;
import java.util.TreeSet;

public class BasicDirectorySearch implements DirectorySearch {

    private Set<DirectorySearchToken> files = new TreeSet();
    private final static Integer LIMIT_TOP = 10;

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
        for(DirectorySearchToken directorySearchToken: this.getTokens()){
            stringBuilder.append(directorySearchToken);
            if( (i+1) >= LIMIT_TOP){
                break;
            }
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
