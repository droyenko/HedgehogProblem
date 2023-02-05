package com.ngoar.application.fixture;

import com.ngoar.domain.infrastructure.ResultProducer;

public class TestResultProducer implements ResultProducer {

    @Override
    public void provideResult(Integer result) {
        System.out.printf("Calculated result is %d%n", result);
    }
}
