package dao.impl;

import dao.BaseDate;
import entity.Goods;
import entity.ShoppingGoods;
import entity.User;

import java.util.HashMap;
import java.util.List;

public class ShoppingGoodsDaoImpl extends BaseDate {
    //添加购物车
    public boolean cart(User user, ShoppingGoods shoppingGoods) {
        boolean flag = false;
        List<Goods> goods = getGoods();
        List<ShoppingGoods> shoppingcar = getShoppingGoods();
        HashMap<User, List<ShoppingGoods>> Shoppingcars = getAllCarts();
        for (Goods goods1 : goods) {
            if (goods1.getName().equals(shoppingGoods.getName()) && goods1.getNum() >= shoppingGoods.getNum() && goods1.getId() == shoppingGoods.getId()) {
                shoppingcar.add(shoppingGoods);
                goods1.setNum(goods1.getNum() - shoppingGoods.getNum());
            }
        }
        Shoppingcars.put(user, shoppingcar);
        if (Shoppingcars.containsKey(user) && Shoppingcars.containsValue(shoppingcar)) {
            flag = true;
        }
        return flag;
    }

    //查看购物车
    public void findMyCart(User user) {
        HashMap<User, List<ShoppingGoods>> Shoppingcars = getAllCarts();
        String value = Shoppingcars.get(user).toString();
        System.out.println(value);
    }

    //购物商品价格
    public double GoodsPrice(User user) {
        double priceSum = 0;
        HashMap<User, List<ShoppingGoods>> Shoppingcars = getAllCarts();
        List<Goods> goods = getGoods();
        List<ShoppingGoods> shoppingGoods = Shoppingcars.get(user);
        for (Goods goods1 : goods) {
            for (ShoppingGoods shoppingGoods1 : shoppingGoods) {
                if (goods1.getName().equals(shoppingGoods1.getName()) && goods1.getId() == shoppingGoods1.getId()) {
                    priceSum += goods1.getPrice() * shoppingGoods1.getNum();
                }
            }
        }
        if (user.getVip() == '1') {
            priceSum *= 0.85;
        } else if (user.getVip() == '0' && priceSum >= 1000) {
            priceSum *= 0.90;
        }
        return priceSum;
    }
}
