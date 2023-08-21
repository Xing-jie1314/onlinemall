package view;

import entity.User;

import java.util.Scanner;

public class Menu {
    public int menu0(User user) {//普通用户
        System.out.println("==========================");
        System.out.println("欢迎" + user.getUsername() + "使用网上购物系统");
        System.out.println("      1.查看商品清单   ");
        System.out.println("      2.查看商品详情   ");
        System.out.println("      3.添加购物车    ");
        System.out.println("      4.查看购物车    ");
        System.out.println("      5.购物商品总价格 ");
        System.out.println("      6.查看用户      ");
        System.out.println("      7.修改密码      ");
        System.out.println("      8.退出登录      ");
        System.out.println("      9.退出系统      ");
        System.out.println("===========================");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public int menu1(User user) {//管理员
        System.out.println("==========================");
        System.out.println("欢迎" + user.getUsername() + "使用网上购物系统");
        System.out.println("      1.查看商品清单   ");
        System.out.println("      2.查看商品详情   ");
        System.out.println("      3.添加商品      ");
        System.out.println("      4.搜索商品      ");
        System.out.println("      5.删除商品      ");
        System.out.println("      6.查看所有用户   ");
        System.out.println("      7.修改密码      ");
        System.out.println("      8.退出登录      ");
        System.out.println("      9.退出系统      ");
        System.out.println("===========================");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
