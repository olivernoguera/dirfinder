package com.schibsted.dirfinder.searcher;


import com.scribsted.dirfinder.directories.BasicDirectory;
import com.scribsted.dirfinder.directories.BasicDirectoryService;
import com.scribsted.dirfinder.inputreader.BasicArgumentsReader;
import com.scribsted.dirfinder.searcher.BasicSearcher;
import com.scribsted.dirfinder.searcher.BasicSearcherLine;
import com.scribsted.dirfinder.searcher.Searcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({BasicSearcher.class})
public class BasicSearcherTest {

    private Searcher searcher = new BasicSearcher();

    @Before
    public void setUp(){

    }


    @Test
    public void run() throws Exception {


        BasicDirectoryService directoryServiceMock = Mockito.mock(BasicDirectoryService.class);
        BasicSearcherLine searcherLineMock = Mockito.mock(BasicSearcherLine.class);
        BasicDirectory directoryMock = Mockito.mock(BasicDirectory.class);
        BasicArgumentsReader argumentsReaderMock = Mockito.mock(BasicArgumentsReader.class);

        PowerMockito.whenNew(BasicDirectoryService.class).withAnyArguments().thenReturn(directoryServiceMock);
        PowerMockito.whenNew(BasicSearcherLine.class).withAnyArguments().thenReturn(searcherLineMock);

        PowerMockito.whenNew(BasicDirectory.class).withAnyArguments().thenReturn(directoryMock);
        PowerMockito.whenNew(BasicArgumentsReader.class).withAnyArguments().thenReturn(argumentsReaderMock);

        String directoryPathMock = "DirectoryPathMock";
        String[] inputArgs = new String[]{directoryPathMock};

        Mockito.when(argumentsReaderMock.readArguments(inputArgs)).thenReturn(directoryPathMock);
        Mockito.doNothing().when(directoryMock).setPathDirectory(directoryPathMock);
        Mockito.doNothing().when(searcherLineMock).scan();

        searcher.run(new String[]{});



    }
}
