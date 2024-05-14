package com.myplayground.DesignPatterns.Strategy.stratagies;

import java.util.ArrayList;
import java.util.List;

public class FileService {

    private FileStrategy fileStrategy;

    public void setStrategy(FileStrategy fileStrategy) {
        this.fileStrategy = fileStrategy;
    }
    public void getFiles(int size) {

        List<String> files =   fileStrategy.find(size);
    }


    public void getFilesInRange(int min, int max) {

        List<String> files =   fileStrategy.find(min, max);
    }
}
