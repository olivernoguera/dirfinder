package com.schibsted.dirfinder.directories;

import com.scribsted.dirfinder.directories.BasicDirectoryService;
import com.scribsted.dirfinder.directories.Directory;
import com.scribsted.dirfinder.directories.DirectoryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

public class BasicDirectoryServiceTest {

    private DirectoryService directoryService;
    private Directory directory;

    @Before
    public void setUp(){
        directory = Mockito.mock(Directory.class);
        directoryService = new BasicDirectoryService(directory);
    }

    @Test
    public void scanDirectory(){
        String mockPath = "mockPath";
        Mockito.doNothing().when(directory).setPathDirectory(mockPath);
        Mockito.when(directory.getFiles()).thenReturn(new File[]{});
        Mockito.when(directory.getPath()).thenReturn(mockPath);
        Directory result = directoryService.scanDirectory(mockPath);

        Assert.assertEquals("Scan directory  files", 0, result.getFiles().length) ;
        Assert.assertEquals("Scan directory  path ", mockPath, result.getPath()) ;

    }
}
