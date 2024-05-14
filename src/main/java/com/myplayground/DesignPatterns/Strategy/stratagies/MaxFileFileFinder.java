package com.myplayground.DesignPatterns.Strategy.stratagies;

import java.util.ArrayList;
import java.util.List;

public class MaxFileFileFinder implements FileStrategy{

    @Override
    public List<String> find(int size) {
        System.out.println(" Find all files larger than size "+ size );
        return new ArrayList<>();
    }

    /**
     * NOT USEFUL **************
     * @param max
     * @param min
     * @return
     */
    @Override
    public List<String> find(int max, int min) {
        return null;
    }
}
