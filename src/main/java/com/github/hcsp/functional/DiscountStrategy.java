package com.github.hcsp.functional;

public interface DiscountStrategy {
    int discount(int price, User user);
}
