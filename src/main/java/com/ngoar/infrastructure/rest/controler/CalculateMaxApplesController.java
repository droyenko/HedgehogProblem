package com.ngoar.infrastructure.rest.controler;

import com.ngoar.domain.usecase.CalculateMaxAmountOfApplesUseCase;

// @RestController
public class CalculateMaxApplesController {

    private final CalculateMaxAmountOfApplesUseCase useCase;

    public CalculateMaxApplesController(CalculateMaxAmountOfApplesUseCase useCase) {
        this.useCase = useCase;
    }

//    @RequestMapping(method = ..., value = ..., produces = ...)
    public void getMaxAmountOfApples() {
        // Calls provided useCase to calculate amount and returns response
        this.useCase.makeHedgehogHappy();

//        return ResponseEntity.ok();
    }
}
