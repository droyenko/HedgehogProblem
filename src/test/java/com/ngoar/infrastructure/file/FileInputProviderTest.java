package com.ngoar.infrastructure.file;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileInputProviderTest {

    @Test
    void givenNotExistingFile_thenThrowsIllegalArgumentException() {
        // Given
        final FileInputProvider inputProvider = new FileInputProvider("NotExistingFile.txt");

        // Then
        assertThrows(IllegalArgumentException.class, inputProvider::provideMatrix);
    }

    @Test
    void givenEmptyInputFile_thenThrowsIllegalArgumentException() {
        // Given
        final FileInputProvider inputProvider = new FileInputProvider("EmptyInput.txt");

        // Then
        assertThrows(IllegalArgumentException.class, inputProvider::provideMatrix);
    }

    @Test
    void givenExistingFile_thenProvideValidMatrix() {
        // Given
        int[][] expectedGarden = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
        };

        final FileInputProvider inputProvider = new FileInputProvider();

        // When
        final int[][] garden = inputProvider.provideMatrix();

        // Then
        assertTrue(Arrays.deepEquals(expectedGarden, garden));
    }
}
