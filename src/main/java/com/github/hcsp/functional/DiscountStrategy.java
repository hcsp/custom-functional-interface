package com.github.hcsp.functional;

public interface DiscountStrategy {
    int getPriceAfterDiscount(int price, User user);
}
