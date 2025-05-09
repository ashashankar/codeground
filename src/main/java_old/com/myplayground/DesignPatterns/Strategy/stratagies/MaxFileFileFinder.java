package com.myplayground.DesignPatterns.Strategy.stratagies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MaxFileFileFinder implements FileStrategy{
    int maxFileSize;
    public MaxFileFileFinder(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    @Override
    public boolean find(Path name) {
        System.out.println(" Find all files larger than size "+ maxFileSize );
        try {
            if (Files.size(name) > maxFileSize) return true;
        } catch (IOException ioException) {
            System.out.println("Excpetion observed");
        }
        return false;
    }
}
