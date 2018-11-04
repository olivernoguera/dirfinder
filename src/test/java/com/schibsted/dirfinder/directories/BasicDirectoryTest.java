package com.schibsted.dirfinder.directories;

import com.scribsted.dirfinder.directories.BasicDirectory;
import com.scribsted.dirfinder.directories.Directory;
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
    public void getFiles() throws IOException {
        directory.setPathDirectory(folder.getRoot().getAbsolutePath());
        Assert.assertEquals(" There is not files", 0, directory.getFiles().length);
        File file = folder.newFile();
        Assert.assertEquals(" There is 1 files", 1, directory.getFiles().length);
        Assert.assertEquals(" There is  files", file, directory.getFiles()[0]);
    }

    @Test
    public void getPatb() throws IOException {
        directory.setPathDirectory(folder.getRoot().getAbsolutePath());
        Assert.assertEquals(" Checking path", folder.getRoot().getPath(), directory.getPath());
    }
}
