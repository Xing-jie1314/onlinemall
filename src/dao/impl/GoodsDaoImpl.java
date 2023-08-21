package dao.impl;

import dao.BaseDate;
import entity.Goods;

import java.util.List;

public class GoodsDaoImpl extends BaseDate {
    //查看商品清单
    public List<Goods> findAllGoods() {
        List<Goods> goods = getGoods();
        for (Goods goods1 : goods) {
            System.out.println(goods1);
        }
        return goods;
    }

    //查看商品详情
    public String showGoods(String goodsname) {
        List<Goods> goods = getGoods();
        for (Goods go : goods) {
            if (go.getName().equals(goodsname)) {
                System.out.println(goodsname + "的信息为以下：");
                return go.toString();
            }
        }
        return "叮叮，商城没有这种东西呢！如有需要，请通过管理员申请添加！";
    }

    //添加商品
    public boolean addGoods(Goods goods) {
        boolean flag = false;
        List<Goods> goods1 = getGoods();
        goods1.add(goods);
        for (Goods goods2 : goods1) {
            if (goods2.equals(goods)) {
                flag = true;
            }
        }
        return flag;
    }

    //搜索商品
    public boolean findGood(String goodsname) {
        boolean flag = false;
        List<Goods> goods1 = getGoods();
        for (Goods goods2 : goods1) {
            if (goods2.getName().equals(goodsname)) {
                System.out.println(goods2);
                flag = true;
            }
        }
        return flag;
    }

    //删除商品
    public boolean delGoods(Goods goods) {
        boolean flag = false;
        List<Goods> goods1 = getGoods();
        for (Goods goods2 : goods1) {
            if (goods2.getName().equals(goods.getName())) {
                goods1.remove(goods.getId() - 1);
                flag = true;
            }
        }
        return flag;
    }

}
