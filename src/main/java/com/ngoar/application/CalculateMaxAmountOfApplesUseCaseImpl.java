package com.ngoar.application;

import java.util.Arrays;

import com.ngoar.domain.infrastructure.InputProvider;
import com.ngoar.domain.infrastructure.ResultPresenter;
import com.ngoar.domain.usecase.CalculateMaxAmountOfApplesUseCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculateMaxAmountOfApplesUseCaseImpl implements CalculateMaxAmountOfApplesUseCase {

    private final InputProvider inputProvider;
    private final ResultPresenter resultPresenter;
    public CalculateMaxAmountOfApplesUseCaseImpl(InputProvider inputProvider, ResultPresenter resultPresenter) {
        this.inputProvider = inputProvider;
        this.resultPresenter = resultPresenter;
    }

    @Override
    public int makeHedgehogHappy() {
        int result = 0;
        try {
            final int[][] garden = this.inputProvider.provideMatrix();
            result = this.calculateMaxAmount(garden);

            log.info("Hedgehog has collected {} apples", result);

            this.resultPresenter.provideResult(result);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    private int calculateMaxAmount(int[][] garden) {
        int m = garden.length;
        int n = garden[0].length;
        int[][] memo = new int[m][n];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return getMax(garden, memo, m - 1, n - 1);
    }

    private int getMax(int[][] garden, int[][] memo, int m, int n) {
        if (m == 0 && n == 0) {
            return garden[0][0];
        }
        if (m < 0 || n < 0) {
            return Integer.MIN_VALUE;
        }
        if (memo[m][n] >= 0) {
            return memo[m][n];
        }

        memo[m][n] = Math.max(getMax(garden, memo, m - 1, n), getMax(garden, memo, m, n - 1)) + garden[m][n];

        return memo[m][n];
    }
}
