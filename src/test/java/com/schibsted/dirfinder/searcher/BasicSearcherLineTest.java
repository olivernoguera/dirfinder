package com.schibsted.dirfinder.searcher;

import com.schibsted.dirfinder.directories.DirectorySearch;
import com.schibsted.dirfinder.directories.DirectorySearchToken;
import com.schibsted.dirfinder.directories.DirectoryService;
import com.schibsted.dirfinder.directories.basic.BasicDirectorySearch;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Matchers.anyString;

public class BasicSearcherLineTest {


    private InputStream keyBoard;

    private DirectoryService directoryServiceMock;

    @Before
    public void setUp(){
        directoryServiceMock = Mockito.mock(DirectoryService.class);
    }

    @Test
    public void testQuit() {
        SearcherLine searcherLine = executeLine(SearcherLine.END_TOKEN);
        searcherLine.scan();
    }

    @Test
    public void findWord() throws IOException {

        String line = "mockLine\n"+SearcherLine.END_TOKEN;
        SearcherLine searcherLine = executeLine(line);
        DirectorySearch directorySearch = new BasicDirectorySearch();
        directorySearch.append(new DirectorySearchToken("file1",90));
        directorySearch.append(new DirectorySearchToken("file2",30));
        Mockito.when(directoryServiceMock.findWord(anyString())).thenReturn(directorySearch);
        searcherLine.scan();

    }

    private SearcherLine executeLine(String line){
        keyBoard = new ByteArrayInputStream(line.getBytes());
        SearcherLine basicSearcherLine = new BasicSearcherLine(keyBoard,directoryServiceMock);
        System.setIn(keyBoard);
        return basicSearcherLine;
    }

}
