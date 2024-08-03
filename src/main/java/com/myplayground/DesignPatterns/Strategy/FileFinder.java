package com.myplayground.DesignPatterns.Strategy;

import com.myplayground.DesignPatterns.Strategy.stratagies.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        List<Path> result =  fileService.getFiles("D:\\Nagesh");
        fileService.setStrategy(new MinSizeFileFilder(10));
        System.out.println( fileService.find(result));
        fileService.setStrategy(new MaxFileFileFinder(20));
        System.out.println( "MAX RESULT ");


        fileService.setStrategy(new AndFileFinder(new MinSizeFileFilder(10), new ExtensionFileFinder("txt")));
        System.out.println( fileService.find(result));







    }
}
