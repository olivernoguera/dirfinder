package com.schibsted.dirfinder.directories.basic;

import com.schibsted.dirfinder.directories.DirectoryMap;
import com.schibsted.dirfinder.directories.DirectorySearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BasicDirectoryMap.class})
public class BasicDirectoryMapTest {

    public static final String FAKEFILE = "FAKEFILE";
    private DirectoryMap directoryMap = new BasicDirectoryMap();
    private File folderMock;
    private File fileInFolderMock;
    private HashMap hashMapMock;
    private BasicFileWords basicFileWordsMock;

    @Before
    public void setUp() throws IOException {
        folderMock = Mockito.mock(File.class);
        fileInFolderMock = Mockito.mock(File.class);
        hashMapMock = Mockito.mock(HashMap.class);
        basicFileWordsMock = Mockito.mock(BasicFileWords.class);
    }

    @Test
    public void loadDirectoryWithDirectory() throws Exception {
        PowerMockito.whenNew(HashMap.class).withAnyArguments().thenReturn(hashMapMock);
        Mockito.when(folderMock.listFiles()).thenReturn(new File[]{fileInFolderMock});
        Mockito.when(fileInFolderMock.isFile()).thenReturn(Boolean.FALSE);

        directoryMap.load(folderMock);
        Assert.assertEquals("Folder read one folder" ,new Integer(0) ,directoryMap.filesScanned());
    }

    @Test(expected = IllegalArgumentException.class)
    public void loadDirectoryFileNotExists() throws Exception {

        PowerMockito.whenNew(HashMap.class).withAnyArguments().thenReturn(hashMapMock);
        PowerMockito.whenNew(BasicFileWords.class).withNoArguments().thenReturn(basicFileWordsMock);
        Mockito.when(folderMock.listFiles()).thenReturn(new File[]{fileInFolderMock});
        Mockito.when(fileInFolderMock.isFile()).thenReturn(Boolean.TRUE);

        Mockito.doThrow(FileNotFoundException.class).when(basicFileWordsMock).loadFile(fileInFolderMock);
        directoryMap.load(folderMock);
    }

    @Test
    public void filesScannedNotLoad(){
        Assert.assertEquals("Files scanned not loaded" ,new Integer(0) ,
                directoryMap.filesScanned());
    }


    @Test
    public void findWordsInDirectoryWithoutFiles()  {
        DirectorySearch directorySearch = directoryMap.findWordsInDirectory("FAKELINE");
        Assert.assertEquals("Folder read one folder" ,0L ,directorySearch.getTokens().size());

    }

    @Test
    public void findEmptyWordsInDirectory() throws Exception {

        mockLoad();

        Mockito.when(hashMapMock.keySet()).thenReturn(new HashSet(Arrays.asList(FAKEFILE)));
        Mockito.when(hashMapMock.get(anyString())).thenReturn(basicFileWordsMock);
        DirectorySearch directorySearch = directoryMap.findWordsInDirectory("");
        Assert.assertEquals("findEmptyWordsInDirectory" ,0L ,directorySearch.getTokens().size());

    }

    @Test
    public void findNullWordsInDirectory() throws Exception {

        mockLoad();
        Mockito.when(hashMapMock.keySet()).thenReturn(new HashSet(Arrays.asList(FAKEFILE)));
        Mockito.when(hashMapMock.get(anyString())).thenReturn(basicFileWordsMock);
        DirectorySearch directorySearch = directoryMap.findWordsInDirectory(null);
        Assert.assertEquals("findNullWordsInDirectory" ,0L ,directorySearch.getTokens().size());

    }

    @Test
    public void findWordInDirectory() throws Exception {

        mockLoad();
        Mockito.when(hashMapMock.keySet()).thenReturn(new HashSet(Arrays.asList(FAKEFILE)));
        Mockito.when(hashMapMock.get(anyString())).thenReturn(basicFileWordsMock);
        Mockito.when(basicFileWordsMock.getPercentOcurrsOneWord("two words")).thenReturn(80);

        DirectorySearch directorySearch = directoryMap.findWordsInDirectory("two words");
        Assert.assertEquals("findWordsInDirectory one token" ,1L ,directorySearch.getTokens().size());
        Assert.assertEquals("findWordsInDirectory namefile" ,FAKEFILE ,directorySearch.getTokens().get(0).getFileName());


    }



    private void mockLoad() throws Exception {
        PowerMockito.whenNew(HashMap.class).withAnyArguments().thenReturn(hashMapMock);
        PowerMockito.whenNew(BasicFileWords.class).withNoArguments().thenReturn(basicFileWordsMock);
        Mockito.when(folderMock.listFiles()).thenReturn(new File[]{fileInFolderMock});
        Mockito.when(fileInFolderMock.isFile()).thenReturn(Boolean.TRUE);
        Mockito.doNothing().when(basicFileWordsMock).loadFile(any());
        directoryMap.load(folderMock);
    }
    /*
    @Test
    public void loadOneWordInDirectory() throws IOException {

        createFilesAndWords(1,1);
        Assert.assertEquals("Folder read one file" ,new Integer(0) ,directoryMap.filesScanned());

        directoryMap.load(folder.getRoot());
        Assert.assertEquals("Folder read one file" ,new Integer(1) ,directoryMap.filesScanned());

        DirectorySearch directorySearch = directoryMap.findWordsInDirectory(BASIC_WORD);
        Assert.assertEquals("Folder read one file" ,createFileName(1),directorySearch.getTokens().get(0).getFileName());

    }

    @Test
    public void findOneWordInOneFile() throws  IOException{
        createFilesAndWords(1,1);
        directoryMap.load(folder.getRoot());
        Assert.assertEquals("Folder read one file" ,new Integer(1) ,directoryMap.filesScanned());

        DirectorySearch directorySearch = directoryMap.findWordsInDirectory(BASIC_WORD);

        Assert.assertEquals("Folder read one file" ,createFileName(1),directorySearch.getTokens().get(0).getFileName());
        Assert.assertEquals("Folder read one file" ,new Integer(100),directorySearch.getTokens().get(0).getPercentMatching());

    }


    public void createFilesAndWords( int numberFiles, int numberWords) throws IOException {
        for(int i = 1; i <= numberFiles;i++){
            String fileName = createFileName(i);
            File file = folder.newFile(fileName);
            StringBuilder words = new StringBuilder();
            for( int j = 0; j < numberWords; j++){
                words.append(BASIC_WORD);
            }
            writeWordInFile(file,words.toString());


        }
    }
    */

}
