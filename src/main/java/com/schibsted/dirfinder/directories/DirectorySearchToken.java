package com.schibsted.dirfinder.directories;

public class DirectorySearchToken implements Comparable<DirectorySearchToken>{

    private final String fileName;
    private final Integer percentMatching;


    public DirectorySearchToken(final String fileName, final Integer percentMatching){
        this.fileName = fileName;
        this.percentMatching = percentMatching;
    }

    public String getFileName() {
        return fileName;
    }

    public Integer getPercentMatching() {
        return percentMatching;
    }

    @Override
    public String toString(){

       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append(this.getFileName());
       stringBuilder.append(" : " );
       stringBuilder.append(this.getPercentMatching());
       stringBuilder.append("%");
       return stringBuilder.toString();
    }

    @Override
    public int compareTo(DirectorySearchToken that) {
        int result = that.getPercentMatching().compareTo(this.getPercentMatching());
        if( result == 0){
            return this.getFileName().compareTo(that.getFileName());
        }else{
            return result;
        }
    }
}
