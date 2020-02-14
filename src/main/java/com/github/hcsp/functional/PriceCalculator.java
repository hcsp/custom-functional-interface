package com.github.hcsp.functional;

public class PriceCalculator {
    public static void main(String[] args) {
        int originalPrice = 100;
        User vipUser = User.vip("张三");
        // 不打折
        int i = calculatePrice((price, user) -> price, originalPrice, vipUser);
        // 全场95折
        calculatePrice((price, user) -> (int) (price * 0.95), originalPrice, vipUser);
        // 只有VIP打95折，其他人保持原价
        calculatePrice(
                (price, user) -> user.isVip() ? (int) (price * 0.95) : price, originalPrice, vipUser);
    }

    interface DiscountStrategy {
        int strategy(int price, User user);
    }

    public static int calculatePrice(DiscountStrategy discountStrategy, int price, User user) {
        return discountStrategy.strategy(price, user);
    }
}
