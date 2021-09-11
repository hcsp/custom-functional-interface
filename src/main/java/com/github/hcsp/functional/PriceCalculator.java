package com.github.hcsp.functional;

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

    public interface DiscountStrategy<P, U> {
        int calculatorPrice(P p, U u);
    }
    // 还记得策略模式么？有了函数式接口之后，策略模式的实现就更加简单了
    // 使用函数式接口重构这个方法，将原先的三种策略作为参数传入
    //
    // 你可以选择自己声明一个接口，例如DiscountStrategy：
    // static int calculatePrice(DiscountStrategy strategy, int price, User user)
    //
    // 或是使用JDK自带的函数式接口BiFunction
    //
    // static int calculatePrice(BiFunction<Integer,User,Integer> strategy, int price, User user)

    public static int calculatePrice(DiscountStrategy<Integer, User> discountStrategy, int price, User user) {
        return discountStrategy.calculatorPrice(price, user);
    }
}
