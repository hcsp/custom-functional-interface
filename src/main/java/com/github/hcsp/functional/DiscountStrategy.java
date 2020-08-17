package com.github.hcsp.functional;

@FunctionalInterface
public interface DiscountStrategy {
    int countPrice(int price, User user);
}
