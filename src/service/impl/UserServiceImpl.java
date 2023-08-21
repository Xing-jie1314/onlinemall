package service.impl;

import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl dao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = dao.login(username, password);
        return user;
    }

    @Override
    public boolean updatePassword(User user, String newPwd1, String newPwd2) {
        return dao.updatePassword(user, newPwd1, newPwd2);
    }

    @Override
    public boolean regist(String username, String password) {
        return dao.regist(username, password);
    }

    @Override
    public List<User> findAllUser() {
        return dao.findAllUser();
    }

}

