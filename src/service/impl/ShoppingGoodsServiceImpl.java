package service.impl;

import dao.impl.GoodsDaoImpl;
import dao.impl.ShoppingGoodsDaoImpl;
import entity.Goods;
import entity.ShoppingGoods;
import entity.User;
import service.ShoppingGoodsService;

import java.util.ArrayList;

public class ShoppingGoodsServiceImpl implements ShoppingGoodsService {
    ShoppingGoodsDaoImpl dao = new ShoppingGoodsDaoImpl();

    @Override
    public boolean cart(User user, ShoppingGoods shoppingGoods) {
        return dao.cart(user, shoppingGoods);
    }

    @Override
    public void findMyCart(User user) {
        dao.findMyCart(user);
    }

    @Override
    public double GoodsPrice(User user) {
        return dao.GoodsPrice(user);
    }
}
