package com.github.hcsp.functional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {
    @Test
    public void test() {
        Assertions.assertEquals(
                80,
                PriceCalculator.calculatePrice((price, user) -> (int) (price * 0.8), 100, null));
    }
}
