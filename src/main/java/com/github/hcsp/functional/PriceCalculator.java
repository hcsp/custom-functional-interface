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

  static int calculatePrice(BiFunction<Integer, User, Integer> strategy, int price, User user) {
    return strategy.apply(price, user);
  }

//  public static int calculatePrice( int price, User user)  {

//    switch (discountStrategy) {
//      case "NoDiscount":
//        return price;
//      case "Discount95":
//        return (int) (price * 0.95);
//      case "OnlyVip": {
//        if (user.isVip()) {
//          return (int) (price * 0.95);
//        } else {
//          return price;
//        }
//      }
//      default:
//        throw new IllegalStateException("Should not be here!");
//    }
//  }
}
