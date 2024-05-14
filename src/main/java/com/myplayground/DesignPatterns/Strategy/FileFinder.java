package com.myplayground.DesignPatterns.Strategy;

import com.myplayground.DesignPatterns.Strategy.stratagies.FileService;
import com.myplayground.DesignPatterns.Strategy.stratagies.MaxFileFileFinder;
import com.myplayground.DesignPatterns.Strategy.stratagies.MinMaxFileFinder;
import com.myplayground.DesignPatterns.Strategy.stratagies.MinSizeFileFilder;

public class FileFinder {
    public static void main(String[] args) {
        FileService service = new FileService();
        service.setStrategy(new MaxFileFileFinder());
        service.getFiles(10000);
        service.setStrategy(new MinSizeFileFilder());
        service.getFiles(10000);
        service.setStrategy(new MinMaxFileFinder());
        service.getFilesInRange(1000, 1300);
    }
}
