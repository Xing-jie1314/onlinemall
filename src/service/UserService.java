package service;

import entity.User;

import java.util.List;

public interface UserService {
    //登录
    User login(String username, String password);

    //修改密码
    boolean updatePassword(User user, String newPwd1, String newPed2);

    //注册
    boolean regist(String username, String password);

    //查看所有用户
    List<User> findAllUser();
}
