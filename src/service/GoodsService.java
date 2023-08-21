package service;

import entity.Goods;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public interface GoodsService {
    //查看商品清单
    List<Goods> findAllGoods();

    //查看商品详情
    String showGoods(String goodsname);

    //添加商品
    boolean addGoods(Goods goods);

    //搜索商品
    boolean findGood(String goodsname);

    //删除商品
    boolean delGoods(Goods goods);

}
