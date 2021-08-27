package com.github.hcsp.functional;

public interface DiscountStrategy<T, U> {
    T strategy(T t, U u);
}
