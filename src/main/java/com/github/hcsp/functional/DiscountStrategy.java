package com.github.hcsp.functional;

public interface DiscountStrategy {
    public abstract int discount(int price, User user);
}
