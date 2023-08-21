package dao.impl;

import dao.BaseDate;
import entity.User;

import java.util.List;

public class UserDaoImpl extends BaseDate {
    //登录
    public User login(String username, String password) {
        User user = null;
        List<User> users = getUsers();
        //获取到进行遍历
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                user = new User(u.getUserId(), u.getUsername(), u.getPassword(), u.getVip(), u.getRole());
                break;
            }
        }
        return user;
    }

    //注册
    public boolean regist(String username, String password) {
        List<User> users = getUsers();
        User user = new User((users.size() + 1), username, password, '0', '0');
        users.add(user);
        if (users.contains(user)) {
            return true;
        } else {
            return false;
        }
    }

    //修改密码
    public boolean updatePassword(User user, String newPwd1, String newPwd2) {
        List<User> users = getUsers();
        if (newPwd1.equals(newPwd2)) {
            User user1 = new User(user.getUserId(), user.getUsername(), newPwd1, user.getVip(), user.getRole());
            users.remove(user.getUserId() - 1);
            users.add(user1);
            if (users.contains(user1)) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("您输入的第一次密码与第二次密码不同");
            return false;
        }
    }

    //查看所有用户
    public List<User> findAllUser() {
        List<User> users = getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("以上是全部用户！");
        return getUsers();
    }
}
