package com.ngoar.hedgehogproblem;

import com.ngoar.application.CalculateMaxAmountOfApplesUseCaseImpl;
import com.ngoar.domain.usecase.CalculateMaxAmountOfApplesUseCase;
import com.ngoar.infrastructure.file.FileInputProvider;
import com.ngoar.infrastructure.file.FileResultProducer;

public class Application {

    public static void main(String[] args) {

        CalculateMaxAmountOfApplesUseCase applesCounter = new CalculateMaxAmountOfApplesUseCaseImpl(
            new FileInputProvider(),
            new FileResultProducer());

        applesCounter.makeHedgehogHappy();

    }

}
