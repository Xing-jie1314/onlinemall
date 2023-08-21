package dao;

import entity.Goods;
import entity.ShoppingGoods;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseDate {
    static List<User> users = new ArrayList<>();
    static List<Goods> goods = new ArrayList<>();
    static List<ShoppingGoods> shoppingGoods = new ArrayList<>();
    static HashMap<User, List<ShoppingGoods>> Shoppingcars = new HashMap<>();

    static {
        User user1 = new User(1, "ttt", "123456", '1', '0');
        User user2 = new User(2, "kkk", "123456", '0', '0');
        User user3 = new User(3, "admin", "123456", '1', '1');
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Goods goods1 = new Goods(1, "苹果", "水果", 12.0, 35, "新鲜可口");
        Goods goods2 = new Goods(2, "短袖", "衣服", 123.0, 1, "质量很好，做工料子都好，颜色也好看。穿着很舒服");
        Goods goods3 = new Goods(3, "篮球", "球类", 200.0, 20, "质量好");
        goods.add(goods1);
        goods.add(goods2);
        goods.add(goods3);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public List<ShoppingGoods> getShoppingGoods() {
        return shoppingGoods;
    }

    public HashMap<User, List<ShoppingGoods>> getAllCarts() {
        return Shoppingcars;
    }

}