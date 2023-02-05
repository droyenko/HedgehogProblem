package com.ngoar.infrastructure.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import com.ngoar.domain.infrastructure.InputProvider;

public class FileInputProvider implements InputProvider {

    public static final String RESOURCE_DIR = "src/main/resources/";
    public static final String INPUT_FILE = "Input.txt";
    public static final String DELIMITER = " ";

    private final String fileName;

    public FileInputProvider() {
        this.fileName = INPUT_FILE;
    }

    // Just for testing purpose
    public FileInputProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int[][] provideMatrix() {

        List<String> inputLines;

        try {
            inputLines = Files.readAllLines(Path.of(RESOURCE_DIR + fileName));
        } catch (IOException e) {
            throw new IllegalArgumentException(
                String.format("File %s cannot be found in %s directory", fileName, RESOURCE_DIR));
        }

        if (inputLines.isEmpty()) {
            throw new IllegalArgumentException(String.format("Provided file %s is empty", fileName));
        }

        final String[] arrayDimensions = inputLines.get(0).split(DELIMITER);
        int[][] garden = new int[Integer.parseInt(arrayDimensions[0])][Integer.parseInt(arrayDimensions[1])];

        System.out.printf("Provided two dimensional array from file %s%n", fileName);

        for (int i = 1; i < inputLines.size(); i++) {
            final String[] applesQuantity = inputLines.get(i).split(DELIMITER);
            System.out.println(Arrays.toString(applesQuantity));

            for (int j = 0; j < applesQuantity.length; j++) {
                garden[i - 1][j] = Integer.parseInt(applesQuantity[j]);
            }
        }

        return garden;
    }

}
