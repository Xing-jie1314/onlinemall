package service.impl;

import dao.impl.GoodsDaoImpl;
import entity.Goods;

import service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDaoImpl dao = new GoodsDaoImpl();

    @Override
    public List<Goods> findAllGoods() {
        return dao.findAllGoods();
    }

    @Override
    public String showGoods(String goodsname) {
        return dao.showGoods(goodsname);
    }

    @Override
    public boolean addGoods(Goods goods) {
        return dao.addGoods(goods);
    }

    @Override
    public boolean findGood(String goodsname) {
        return dao.findGood(goodsname);
    }

    @Override
    public boolean delGoods(Goods goods) {
        return dao.delGoods(goods);
    }

}
