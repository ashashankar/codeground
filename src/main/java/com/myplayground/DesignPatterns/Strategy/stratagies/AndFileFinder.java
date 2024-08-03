package com.myplayground.DesignPatterns.Strategy.stratagies;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class AndFileFinder implements  FileStrategy{
    List<FileStrategy> fileStrategies;
    public AndFileFinder(FileStrategy... fileStrategies) {
        this.fileStrategies = Arrays.asList(fileStrategies);
    }

    @Override
    public boolean find(Path file) {

        for (FileStrategy fileStrategy : fileStrategies) {
            if(!fileStrategy.find(file)) {
                return false;
            }
        }
        return true;
    }

}
