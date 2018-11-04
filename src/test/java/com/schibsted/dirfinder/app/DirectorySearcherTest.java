package com.schibsted.dirfinder.app;


import com.schibsted.dirfinder.searcher.BasicSearcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DirectorySearcher.class})
public class DirectorySearcherTest {

    @Test
    public void testApp() throws Exception {

        String pathMock = "testPath";
        String[] args = new String[]{pathMock};
        BasicSearcher basicSearcher = Mockito.mock(BasicSearcher.class);
        Mockito.doNothing().when(basicSearcher).run(args);
        PowerMockito.whenNew(BasicSearcher.class).withNoArguments().thenReturn(basicSearcher);
        DirectorySearcher.main(args);

    }
}
