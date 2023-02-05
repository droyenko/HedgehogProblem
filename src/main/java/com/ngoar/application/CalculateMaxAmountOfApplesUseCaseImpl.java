package com.ngoar.application;

import com.ngoar.domain.infrastructure.InputProvider;
import com.ngoar.domain.infrastructure.ResultProducer;
import com.ngoar.domain.usecase.CalculateMaxAmountOfApplesUseCase;

public class CalculateMaxAmountOfApplesUseCaseImpl implements CalculateMaxAmountOfApplesUseCase {

    private final InputProvider inputProvider;
    private final ResultProducer resultProducer;

    public CalculateMaxAmountOfApplesUseCaseImpl(InputProvider inputProvider, ResultProducer resultProducer) {
        this.inputProvider = inputProvider;
        this.resultProducer = resultProducer;
    }

    @Override
    public int makeHedgehogHappy() {
        int result = 0;
        try {
            final int[][] garden = this.inputProvider.provideMatrix();
            result = this.calculateMaxAmount(garden);

            System.out.printf("Hedgehog has collected %d apples%n", result);

            this.resultProducer.provideResult(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private int calculateMaxAmount(int[][] garden) {
        int m = garden.length - 1;
        int n = garden[0].length - 1;
        return getMax(garden, m, n);
    }

    private int getMax(int[][] garden, int m, int n) {
        if (m == 0 && n == 0) {
            return garden[0][0];
        }
        if (m < 0 || n < 0) {
            return Integer.MIN_VALUE;
        }

        return garden[m][n] + Math.max(getMax(garden, m - 1, n), getMax(garden, m, n - 1));
    }
}
