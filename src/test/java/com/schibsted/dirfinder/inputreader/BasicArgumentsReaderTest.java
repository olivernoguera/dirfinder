package com.schibsted.dirfinder.inputreader;

import com.scribsted.dirfinder.inputreader.ArgumentsReader;
import com.scribsted.dirfinder.inputreader.BasicArgumentsReader;
import org.junit.Assert;
import org.junit.Test;


public class BasicArgumentsReaderTest {

    @Test(expected = IllegalArgumentException.class)
    public void readArgumentsNullParameters(){
        ArgumentsReader argumentsReader = new BasicArgumentsReader();
        argumentsReader.readArguments(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readArgumentsEmptyParameters(){
        ArgumentsReader argumentsReader = new BasicArgumentsReader();
        argumentsReader.readArguments(new String[]{});
    }

    @Test
    public void readArgumentsCorret(){
        ArgumentsReader argumentsReader = new BasicArgumentsReader();
        String mockDir = "mockDir";
        String result = argumentsReader.readArguments(new String[]{mockDir});
        Assert.assertEquals(mockDir,result);
    }
}
