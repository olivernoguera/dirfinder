package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.Directory;
import com.schibsted.dirfinder.directories.DirectorySearch;
import com.schibsted.dirfinder.directories.DirectorySearchToken;
import com.schibsted.dirfinder.directories.DirectoryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;

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
        Mockito.when(directory.getPath()).thenReturn(mockPath);
        Directory result = directoryService.scanDirectory(mockPath);

        Assert.assertEquals("Scan directory  files",
                new Integer(0), result.getNumberReadFiles()) ;
        Assert.assertEquals("Scan directory  path ", mockPath, result.getPath()) ;
    }

    @Test
    public void findWord(){

        String wordTest = "test";
        DirectorySearch expectedDirectorySearch = new BasicDirectorySearch();
        expectedDirectorySearch.append(new DirectorySearchToken("file1",30));
        expectedDirectorySearch.append(new DirectorySearchToken("file2",40));
        String expectedStringResult = "file2 : 40% file1 : 30%";

        Mockito.when(directory.findWordsInDirectory(wordTest)).thenReturn(expectedDirectorySearch);
        DirectorySearch directorySearchResult = directoryService.findWord(wordTest);
        Assert.assertThat("findWord",  expectedDirectorySearch,
                is(directorySearchResult));
        Assert.assertThat("findWord string",  directorySearchResult.toString(),
                (is(expectedStringResult)));


    }


    @Test
    public void findWordNotMatches(){

        String wordTest = "test";
        DirectorySearch expectedDirectorySearch = new BasicDirectorySearch();
        String expectedStringResult = "no matches found";

        Mockito.when(directory.findWordsInDirectory(wordTest)).thenReturn(expectedDirectorySearch);
        DirectorySearch directorySearchResult = directoryService.findWord(wordTest);
        Assert.assertThat("findWord string",  directorySearchResult.toString(),
                is(expectedStringResult));


    }
}
