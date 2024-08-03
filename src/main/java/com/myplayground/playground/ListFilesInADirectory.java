package com.myplayground.playground;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFilesInADirectory {
    public static void main(String[] args) throws IOException {
        String directory = "D:\\Nagesh";
        listFilesUsingNIO(directory);
        listAllFilesRecursive(new File(directory));
        findFilesByExtension(directory, "txt");
        findFilesBySize(directory, 2);

    }

    public static void listFilesUsingNIO(String directory) {
        Path path = Paths.get(directory);
        try {
            List<Path> files = listFiles(path);
            files.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Path> listFiles(Path path) throws IOException {
        Stream<Path> walk = Files.walk(path, Integer.MAX_VALUE);
        return walk.filter(Files::isRegularFile).collect(Collectors.toList());
    }

    public static void findFilesByExtension(String directory, String extension) throws IOException {
        Path path = Paths.get(directory);
        Stream<Path> pathStream = Files.walk(path);
        List<Path> matchedFiles = pathStream.filter(Files::isRegularFile).filter(file -> file.getFileName().toString().endsWith(extension)).toList();
        matchedFiles.forEach(System.out::println);
    }

    public static void findFilesBySize(String directory, long filesize) throws IOException {
        Path path = Paths.get(directory);
        Stream<Path> pathStream = Files.walk(path, Integer.MAX_VALUE);
        List<Path> matchedFiles = pathStream
                .filter(Files::isRegularFile)
                .filter(file -> checkFileSize(file, filesize))
                .toList();
        matchedFiles.forEach(System.out::println);
    }

    private static boolean checkFileSize(Path f, long fileSize) {
        boolean result = false;
        try {
            if (Files.size(f) >= fileSize){
                result = true;
            }
        } catch (IOException ioException) {
            System.out.println(" IO Excpetion occurred");
        }
        return result;
    }

    public static void listAllFilesRecursive(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                listAllFilesRecursive(f);
            } else {
                System.out.println(f);
            }
        }

    }
}

