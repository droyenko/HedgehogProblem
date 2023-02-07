package com.ngoar.application.fixture;

import com.ngoar.domain.infrastructure.ResultPresenter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestResultPresenter implements ResultPresenter {

    @Override
    public void provideResult(Integer result) {
        log.info("Calculated result is {}", result);
    }
}
