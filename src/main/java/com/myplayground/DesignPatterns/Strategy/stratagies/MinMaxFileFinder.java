package com.myplayground.DesignPatterns.Strategy.stratagies;

import java.util.ArrayList;
import java.util.List;

public class MinMaxFileFinder implements  FileStrategy{
    /****
     * NOT USEFUL
     * @param size
     * @return
     */
    @Override
    public List<String> find(int size) {
        return null;
    }

    @Override
    public List<String> find(int max, int min) {
        System.out.println(" Find all files with size between min and max ");
        return new ArrayList<>();
    }
}
