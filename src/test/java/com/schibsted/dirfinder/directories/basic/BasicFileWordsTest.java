package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.FileWords;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BasicFileWordsTest {

    private FileWords fileWords = new BasicFileWords();
    private TemporaryFolder folder = new TemporaryFolder();
    private final static String BASIC_FILE = "testFile";
    private final static String BASIC_WORD = "testWord";

    private File file;
    private FileOutputStream fileOutputStream;

    @Before
    public void setUp() throws IOException {
        folder.create();
        file = folder.newFile(BASIC_FILE);
        fileOutputStream = new FileOutputStream(file);

    }

    @Test(expected = IllegalArgumentException.class)
    public void loadFileDirectory() throws FileNotFoundException {
        fileWords.loadFile(folder.getRoot());
    }

    @Test
    public void loadFileAndSearchFile() throws IOException {
        appendWords( 9);
        String fakeWord = "fakeWord";
        writeWordInFile("fakeWord");
        fileWords.loadFile(file);
        fileOutputStream.close();
        Assert.assertEquals(BASIC_WORD + " must be 90%" , new Integer(90),
                fileWords.getPercentOcurrsOneWord(BASIC_WORD));
        Assert.assertEquals(fakeWord + " must be 10%" , new Integer(10),
                fileWords.getPercentOcurrsOneWord(fakeWord));

    }

    public void appendWords(int numberWords) throws IOException {
        StringBuilder words = new StringBuilder();
        for (int j = 1; j <= numberWords; j++) {
            words.append(BASIC_WORD);
            if( j <=  numberWords){
                words.append(" ");
            }
        }
        writeWordInFile( words.toString());
    }


    public void writeWordInFile(String word) throws IOException {
        fileOutputStream.write(word.getBytes());
    }
}
