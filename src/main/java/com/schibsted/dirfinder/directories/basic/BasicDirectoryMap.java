package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.DirectoryMap;
import com.schibsted.dirfinder.directories.DirectorySearch;
import com.schibsted.dirfinder.directories.DirectorySearchToken;
import com.schibsted.dirfinder.directories.FileWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BasicDirectoryMap implements DirectoryMap {

    private Map<String, FileWords> fileWordsByFileName;

    @Override
    public void load(File directory) {
        this.fileWordsByFileName = new HashMap<>();
        for (File file : directory.listFiles()) {
            try {
                loadFile(file);
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException("File " + file.getName() + " can not open.");
            }
        }
    }

    private void loadFile(File file) throws FileNotFoundException {

        if (!file.isFile() ) {
            return;
        }
        String fileName = file.getName();
        FileWords fileWords = new BasicFileWords();
        fileWords.loadFile(file);
        this.fileWordsByFileName.put(fileName, fileWords);
    }

    public DirectorySearch findWordsInDirectory(String line) {
        DirectorySearch directorySearch = new BasicDirectorySearch();
        for (String fileName : this.getFilesName()) {

            FileWords fileWords = this.fileWordsByFileName.get(fileName);
            Integer ocurrsWord = fileWords.getPercentOcurrsOneWord(line);
            if(ocurrsWord > 0){
                DirectorySearchToken directorySearchToken =
                        new DirectorySearchToken(fileName, fileWords.getPercentOcurrsOneWord(line));
                directorySearch.append(directorySearchToken);
            }
        }
        return directorySearch;

    }

    private Set<String> getFilesName(){
        if( this.fileWordsByFileName == null){
            return new HashSet();
        }
        return this.fileWordsByFileName.keySet();
    }

    @Override
    public Integer filesScanned() {
        if( this.fileWordsByFileName == null){
            return 0;
        }
        return this.fileWordsByFileName.size();
    }

}
