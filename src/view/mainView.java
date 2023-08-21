package view;

import entity.Goods;
import entity.ShoppingGoods;
import entity.User;
import service.GoodsService;
import service.ShoppingGoodsService;
import service.UserService;
import service.impl.GoodsServiceImpl;
import service.impl.ShoppingGoodsServiceImpl;
import service.impl.UserServiceImpl;

import java.util.Scanner;

public class mainView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        UserService userService = new UserServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        ShoppingGoodsService shoppingGoodsService = new ShoppingGoodsServiceImpl();
        loop1:
        while (true) {
            System.out.println("========================");
            System.out.println("     欢迎登录网上商城      ");
            System.out.println("         1.登录          ");
            System.out.println("         2.注册          ");
            System.out.println("         3.退出          ");
            System.out.println("========================");
            System.out.println("请输入您的选择：");
            int selected = sc.nextInt();
            if (selected == 1) {
                System.out.println("请输入账号:");
                String username = sc.next();
                System.out.println("请输入密码:");
                String password = sc.next();
                User user = userService.login(username, password);
                if (user != null) {
                    if (user.getRole() == '0') {
                        System.out.println("登录成功，欢迎普通用户登录");
                        loop2:
                        while (true) {
                            switch (menu.menu0(user)) {
                                case 1:
                                    goodsService.findAllGoods();
                                    break;
                                case 2:
                                    System.out.println("请输入要查看的商品名称：");
                                    String goodsname = sc.next();
                                    System.out.println(goodsService.showGoods(goodsname));
                                    break;
                                case 3:
                                    System.out.println("请输入要购买的商品信息：");
                                    System.out.println("编号：");
                                    int id1 = sc.nextInt();
                                    System.out.println("名称：");
                                    String name1 = sc.next();
                                    System.out.println("数量:");
                                    int num1 = sc.nextInt();
                                    ShoppingGoods shoppingGoods = new ShoppingGoods(id1, name1, num1);
                                    if (shoppingGoodsService.cart(user, shoppingGoods)) {
                                        System.out.println("添加成功！");
                                    } else {
                                        System.out.println("添加失败！");
                                    }
                                    break;
                                case 4:
                                    System.out.println("以下为" + username + "的购物车：");
                                    shoppingGoodsService.findMyCart(user);
                                    break;
                                case 5:
                                    System.out.println("您应支付" + shoppingGoodsService.GoodsPrice(user) + "元");
                                    break;
                                case 6:
                                    userService.findAllUser();
                                    break;
                                case 7:
                                    System.out.println("请输入新密码：");
                                    String newpwd1 = sc.next();
                                    System.out.println("请再次输入新密码：");
                                    String newpwd2 = sc.next();
                                    if (userService.updatePassword(user, newpwd1, newpwd2)) {
                                        System.out.println("修改成功，请重新登录！");
                                        continue loop1;
                                    } else {
                                        System.out.println("修改失败！");
                                    }
                                    break;
                                case 8:
                                    continue loop1;
                                case 9:
                                    System.out.println("退出网上购物！");
                                    System.exit(-1);
                                    break;
                                default:
                                    System.out.println("您的输入有误，请重新输入!");
                                    continue loop1;
                            }
                        }
                    } else if (user.getRole() == '1') {
                        System.out.println("登录成功，欢迎管理员登录");
                        loop3:
                        while (true) {
                            switch (menu.menu1(user)) {
                                case 1:
                                    goodsService.findAllGoods();
                                    break;
                                case 2:
                                    System.out.println("请输入要查看的商品名称：");
                                    String goodsname = sc.next();
                                    System.out.println(goodsService.showGoods(goodsname));
                                    break;
                                case 3:
                                    Goods goods = getGoods("请依次输入要添加的商品信息：", sc);
                                    if (goodsService.addGoods(goods)) {
                                        System.out.println("添加成功！");
                                    } else {
                                        System.out.println("添加失败！");
                                    }
                                    break;
                                case 4:
                                    System.out.println("请输入要搜索的商品名称：");
                                    String name = sc.next();
                                    if (goodsService.findGood(name)) {
                                        System.out.println("搜索成功！");
                                    } else {
                                        System.out.println("搜索失败！");
                                    }
                                    break;
                                case 5:
                                    System.out.println("请输入要删除的商品信息：");
                                    System.out.println("编号：");
                                    int id1 = sc.nextInt();
                                    System.out.println("名称：");
                                    String name1 = sc.next();
                                    Goods goods1 = new Goods(id1, name1);
                                    if (goodsService.delGoods(goods1)) {
                                        System.out.println("删除成功！");
                                    } else {
                                        System.out.println("删除失败！");
                                    }
                                    break;
                                case 6:
                                    userService.findAllUser();
                                    break;
                                case 7:
                                    System.out.println("请输入新密码：");
                                    String newpwd1 = sc.next();
                                    System.out.println("请再次输入新密码：");
                                    String newpwd2 = sc.next();
                                    if (userService.updatePassword(user, newpwd1, newpwd2)) {
                                        System.out.println("修改成功，请重新登录！");
                                        continue loop1;
                                    } else {
                                        System.out.println("修改失败!");
                                    }
                                    break;
                                case 8:
                                    continue loop1;
                                case 9:
                                    System.out.println("退出网上购物！");
                                    System.exit(-1);
                                    break;
                                default:
                                    System.out.println("您的输入有误，请重新输入!");
                                    break loop3;
                            }
                        }
                    }
                } else {
                    System.out.println("您输入的账号密码有误，请重新输入！");
                }
            } else if (selected == 2) {
                System.out.println("欢迎注册账号");
                System.out.println("请输入账号:");
                String username = sc.next();
                System.out.println("请输入密码:");
                String password = sc.next();
                userService.regist(username, password);
                if (userService.regist(username, password)) {
                    System.out.println("注册成功！");
                } else {
                    System.out.println("注册失败！");
                }
            } else {
                System.out.println("退出网上购物！");
                System.exit(0);
            }
        }
    }

    private static Goods getGoods(String x, Scanner sc) {
        System.out.println(x);
        System.out.println("编号：");
        int id = sc.nextInt();
        System.out.println("名称：");
        String name = sc.next();
        System.out.println("种类:");
        String type = sc.next();
        System.out.println("价格：");
        double price = sc.nextDouble();
        System.out.println("数量：");
        int num = sc.nextInt();
        System.out.println("评价：");
        String evaluate = sc.next();
        Goods goods = new Goods(id, name, type, price, num, evaluate);
        return goods;
    }
}
