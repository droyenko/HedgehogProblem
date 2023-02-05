package com.ngoar.application.fixture;

import com.ngoar.domain.infrastructure.InputProvider;

public class TestInputProvider implements InputProvider {

    private final int[][] inMemoryData;

    private TestInputProvider(int[][] inMemoryData) {
        this.inMemoryData = inMemoryData;
    }

    public static TestInputProvider of(int[][] inMemoryData) {
        return new TestInputProvider(inMemoryData);
    }

    @Override
    public int[][] provideMatrix() {
        return this.inMemoryData;
    }
}
