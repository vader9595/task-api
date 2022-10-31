package com.velasquez.taskapi.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzbuzzTest {

    Fizzbuzz fizzbuzz = new Fizzbuzz();

    @Test
    void returnsFizzBuzzWhenDivisableBy3_And_5() {

        String result = fizzbuzz.calculate(15);

        Assertions.assertEquals("FizzBuzz",result);

    }

    @Test
    void returnsFizzWhenDivisableBy3() {

            String result = fizzbuzz.calculate(3);

             Assertions.assertEquals("Fizz",result);

    }

    @Test
    void returnsBuzzWhenDivisableBy5() {

        String result = fizzbuzz.calculate(5);

        Assertions.assertEquals("Buzz",result);

    }


    @Test
    void justReturnsTheNumberBcItsNotDivisableBy3_Or_5() {

        String result = fizzbuzz.calculate(2);

        Assertions.assertEquals("2",result);

    }

}