package com.ngoar.infrastructure.database;

import com.ngoar.domain.infrastructure.InputProvider;

public class DataBaseInputProvider implements InputProvider {

    @Override
    public int[][] provideMatrix() {
        // Reads from database and provides input
        return new int[0][];
    }
}
