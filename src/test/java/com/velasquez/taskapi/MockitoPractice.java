package com.velasquez.taskapi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoPractice {
    
    Calculator mockCalculator = Mockito.mock(Calculator.class);

    @Test
    void name() {
        Mockito.when(mockCalculator.sum(1,2))
                .thenReturn(15);        /* this will fail the test bc we Told this "mock clone" to
                                               return 15 here instead of 3 */

    int result = mockCalculator.sum(1,2);

        Assertions.assertThat(result).isEqualTo(3);
    }
}

class Calculator {

    public int sum(int num1, int num2) {

        return num1 + num2;
    }
}