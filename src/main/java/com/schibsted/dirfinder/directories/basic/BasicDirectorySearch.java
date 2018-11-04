package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.DirectorySearch;
import com.schibsted.dirfinder.directories.DirectorySearchToken;

import java.util.ArrayList;
import java.util.List;

public class BasicDirectorySearch implements DirectorySearch {

    private List<DirectorySearchToken> files = new ArrayList();


    public void append(DirectorySearchToken directorySearchToken) {
        files.add(directorySearchToken);
    }

    @Override
    public String toString(){
        final StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i< files.size();i++){
            stringBuilder.append(files.get(i));
            if ((i +1) < files.size()){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public List<DirectorySearchToken> getTokens(){
        return files;
    }
}
