package com.github.hcsp.functional;

public interface DiscountStrategy {
    abstract int discount(int price, User user);
}
