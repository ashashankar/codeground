package com.myplayground.DesignPatterns.Strategy.stratagies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MinSizeFileFilder implements FileStrategy {
    int minSize;
    public MinSizeFileFilder(int min) {
        this.minSize = min;
    }
    @Override
    public boolean find(Path file) {
        System.out.println(" Find all files smaller than size "+ minSize );
        try {
            if (Files.size(file) < minSize) return true;
        } catch (IOException ioException) {
            System.out.println("Excpetion observed");
        }
        return false;
    }

}
