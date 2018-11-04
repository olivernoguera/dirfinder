package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.FileWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BasicFileWords implements FileWords {


    private Map<String,Integer> ocurrsByWord = new HashMap<>();
    private Double numberWords;

    @Override
    public Integer getPercentOcurrsOneWord(String word) {
        Double percentOcurrs = (double) (this.getOcurrsOneWord(word)/numberWords);
        percentOcurrs = percentOcurrs*100.0;
        return new Long(Math.round(percentOcurrs)).intValue();
    }

    private Integer getOcurrsOneWord(String word) {
        Integer ocurrs = ocurrsByWord.get(word);
        if( ocurrs == null){
            return 0;
        }
        return ocurrs;
    }


    @Override
    public void loadFile(File file) throws FileNotFoundException {
        if( !file.isFile()){
            throw new IllegalArgumentException("File " +file.getName()+"  must not be a directory");
        }
        ocurrsByWord = new HashMap();
        numberWords = 0.0;
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            String word = scanner.next();
            Integer ocurrs = this.getOcurrsOneWord(word);
            ocurrs++;
            numberWords++;
            ocurrsByWord.put(word,ocurrs);
        }
    }
}
