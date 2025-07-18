package com.myplayground.temp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {


    public static List<String> loadCSV(String fileName, String filePath) throws Exception {
        List<String> result = new ArrayList<>();
        try {
            String line = null;
            BufferedReader buffererdReader = new BufferedReader(new FileReader(fileName));
            buffererdReader.readLine();
            while ((line = buffererdReader.readLine()) != null) {

                String[] tokens = line.split(",");
                if (tokens.length> 10) continue;
                String id = tokens[0];
                if (Integer.parseInt(id)>50) {
                    result.add(line);
                }
            }
        } catch (IOException fx) {
            throw new Exception(fx);
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        String filename = "data.csv";
        String filePath = ".";
        List<String> result = loadCSV(filename, filePath);
        System.out.println(result);
    }
}
