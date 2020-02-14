package com.github.hcsp.functional;

import java.util.function.BiFunction;

public class PriceCalculator {
    public static void main(String[] args) {
        int originalPrice = 100;
        User vipUser = User.vip("张三");
        // 不打折
        calculatePrice((price, user) -> price, originalPrice, vipUser);
        // 全场95折
        calculatePrice((price, user) -> (int) (price * 0.95), originalPrice, vipUser);
        // 只有VIP打95折，其他人保持原价
        calculatePrice(
                (price, user) -> user.isVip() ? (int) (price * 0.95) : price,
                originalPrice,
                vipUser);

    }

    public static int calculatePrice(BiFunction<Integer, User, Integer> stragegy, int price, User user) {
        return stragegy.apply(price, user);
    }
}
