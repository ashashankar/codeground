package com.myplayground.DesignPatterns.Strategy.stratagies;

import java.util.List;

public interface FileStrategy {
    List<String> find(int size);

    List<String> find(int max, int min);


}
