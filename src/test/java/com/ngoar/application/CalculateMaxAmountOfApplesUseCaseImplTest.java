package com.ngoar.application;

import com.ngoar.application.fixture.TestInputProvider;
import com.ngoar.application.fixture.TestResultProducer;
import com.ngoar.domain.infrastructure.InputProvider;
import com.ngoar.domain.infrastructure.ResultProducer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateMaxAmountOfApplesUseCaseImplTest {

    private final ResultProducer resultProducer = new TestResultProducer();

    @Test
    void givenArrayFromTechTask_thenReturnExpectedResult() {
        // Given
        int[][] garden = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
        };

        final InputProvider inputProvider = TestInputProvider.of(garden);
        final CalculateMaxAmountOfApplesUseCaseImpl useCase = new CalculateMaxAmountOfApplesUseCaseImpl(
            inputProvider, this.resultProducer);

        // When
        final int result = useCase.makeHedgehogHappy();

        // Then
        assertEquals(12, result);
    }

    @Test
    void givenArrayOfZeroes_thenReturnZero() {
        // Given
        int[][] garden = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
        };

        final InputProvider inputProvider = TestInputProvider.of(garden);
        final CalculateMaxAmountOfApplesUseCaseImpl useCase = new CalculateMaxAmountOfApplesUseCaseImpl(
            inputProvider, this.resultProducer);

        // When
        final int result = useCase.makeHedgehogHappy();

        // Then
        assertEquals(0, result);
    }

    @Test
    void givenArrayOfOneDimension_thenReturnItsValue() {
        // Given
        int[][] garden = {
            {1},
        };

        final InputProvider inputProvider = TestInputProvider.of(garden);
        final CalculateMaxAmountOfApplesUseCaseImpl useCase = new CalculateMaxAmountOfApplesUseCaseImpl(
            inputProvider, this.resultProducer);

        // When
        final int result = useCase.makeHedgehogHappy();

        // Then
        assertEquals(1, result);
    }

    @Test
    void givenArrayOfOneColumn_thenReturnSumOfItsValue() {
        // Given
        int[][] garden = {
            {1},
            {1},
            {1},
            {1},
            {1},
        };

        final InputProvider inputProvider = TestInputProvider.of(garden);
        final CalculateMaxAmountOfApplesUseCaseImpl useCase = new CalculateMaxAmountOfApplesUseCaseImpl(
            inputProvider, this.resultProducer);

        // When
        final int result = useCase.makeHedgehogHappy();

        // Then
        assertEquals(5, result);
    }

    @Test
    void givenArrayOfOneRow_thenReturnSumOfItsValue() {
        // Given
        int[][] garden = {
            {1, 1, 1, 1, 1},
        };

        final InputProvider inputProvider = TestInputProvider.of(garden);
        final CalculateMaxAmountOfApplesUseCaseImpl useCase = new CalculateMaxAmountOfApplesUseCaseImpl(
            inputProvider, this.resultProducer);

        // When
        final int result = useCase.makeHedgehogHappy();

        // Then
        assertEquals(5, result);
    }

    @Test
    void givenArrayWithTraversalDiagonal_thenReturnSumOfItsValue() {
        // Given
        int[][] garden = {
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1},
        };

        final InputProvider inputProvider = TestInputProvider.of(garden);
        final CalculateMaxAmountOfApplesUseCaseImpl useCase = new CalculateMaxAmountOfApplesUseCaseImpl(
            inputProvider, this.resultProducer);

        // When
        final int result = useCase.makeHedgehogHappy();

        // Then
        assertEquals(5, result);
    }

    @Test
    void givenArrayWithNonTraversalDiagonal_thenReturnOne() {
        // Given
        int[][] garden = {
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0},
        };

        final InputProvider inputProvider = TestInputProvider.of(garden);
        final CalculateMaxAmountOfApplesUseCaseImpl useCase = new CalculateMaxAmountOfApplesUseCaseImpl(
            inputProvider, this.resultProducer);

        // When
        final int result = useCase.makeHedgehogHappy();

        // Then
        assertEquals(1, result);
    }
}