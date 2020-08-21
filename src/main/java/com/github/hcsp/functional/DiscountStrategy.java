package com.github.hcsp.functional;

public interface DiscountStrategy {
    int getDiscount(int price, User user);
}
