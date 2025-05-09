package com.myplayground.DesignPatterns.Strategy.stratagies;

import java.nio.file.Path;

public class ExtensionFileFinder implements FileStrategy {

    String extension;
    public ExtensionFileFinder(String ext) {
        this.extension = ext;
    }

    public boolean find(Path p) {
        return p.getFileName().toString().endsWith(extension);
    }
}
