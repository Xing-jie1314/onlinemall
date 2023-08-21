package service;

import entity.Goods;
import entity.ShoppingGoods;
import entity.User;

import java.util.ArrayList;

public interface ShoppingGoodsService {
    //添加购物车
    boolean cart(User user, ShoppingGoods shoppingGoods);

    //查看购物车
    void findMyCart(User user);

    //购物商品价格
    double GoodsPrice(User user);
}
