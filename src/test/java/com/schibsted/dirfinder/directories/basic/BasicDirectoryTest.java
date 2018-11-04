package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.Directory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class BasicDirectoryTest {

    private Directory directory = new BasicDirectory();
    private TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        folder.create();
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPathCanNotRead(){
        directory.setPathDirectory("/mock");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPathNotDirectory() throws IOException {
        File file = folder.newFile();
        directory.setPathDirectory(file.getPath());
    }

    @Test
    public void setPathDirectoryOK() {
        directory.setPathDirectory(folder.getRoot().getAbsolutePath());
    }

    @Test
    public void getNumberReadFiles() throws IOException {
        directory.setPathDirectory(folder.getRoot().getAbsolutePath());
        Assert.assertEquals(" There is not files", new Integer(0), directory.getNumberReadFiles());
        folder.newFile();
        directory.setPathDirectory(folder.getRoot().getAbsolutePath());
        Assert.assertEquals(" There is 1 files", new Integer(1), directory.getNumberReadFiles());
    }

    @Test
    public void findWordsInDirectory() throws IOException {
        String words = "MockWords";
        directory.setPathDirectory(folder.getRoot().getAbsolutePath());
        directory.findWordsInDirectory(words);
    }

    @Test
    public void getPath() throws IOException {
        directory.setPathDirectory(folder.getRoot().getAbsolutePath());
        Assert.assertEquals(" Checking path", folder.getRoot().getPath(), directory.getPath());
    }
}
