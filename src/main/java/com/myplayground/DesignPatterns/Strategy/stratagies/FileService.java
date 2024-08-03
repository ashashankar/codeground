package com.myplayground.DesignPatterns.Strategy.stratagies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

    private FileStrategy fileStrategy;

    public void setStrategy(FileStrategy fileStrategy) {
        this.fileStrategy = fileStrategy;
    }
    public List<Path> getFiles(String directory) {
        Path p = Paths.get(directory);
        List<Path> result = new ArrayList<>();
        if (Files.isDirectory(p)) {
            try(Stream<Path> pathStream = Files.walk(p, Integer.MAX_VALUE)) {
                result = pathStream.filter(Files::isRegularFile).collect(Collectors.toList());
            } catch (IOException ioException) {
                System.out.println(" Exception Occured while reading the file ");
            }
        }
        return result;
    }

    public List<String> find(List<Path> paths) {
        List<String> result = new ArrayList<>();
        for (Path p : paths) {
            if (fileStrategy.find(p)) {
                result.add(p.getFileName().toString());
            }
        }
        return  result;
    }
}
