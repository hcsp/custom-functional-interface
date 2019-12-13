package com.github.hcsp.functional;

public interface DiscountStrategy {
    Integer getPreferentialPrice(Integer price, User user);
}
