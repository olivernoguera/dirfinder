package com.schibsted.dirfinder.searcher;

import com.scribsted.dirfinder.directories.DirectoryService;
import com.scribsted.dirfinder.searcher.BasicSearcherLine;
import com.scribsted.dirfinder.searcher.SearcherLine;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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

        String line = "mockLine\n\r"+SearcherLine.END_TOKEN;
        SearcherLine searcherLine = executeLine(line);
        Mockito.doNothing().when(directoryServiceMock).findWord(line);
        searcherLine.scan();

    }

    private SearcherLine executeLine(String line){
        keyBoard = new ByteArrayInputStream(line.getBytes());
        SearcherLine basicSearcherLine = new BasicSearcherLine(keyBoard,directoryServiceMock);
        System.setIn(keyBoard);
        return basicSearcherLine;
    }

}
