package ddd.services;

import ddd.dao.UserDao;
import ddd.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
            this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void changeUser(User user) {
        this.userDao.changeUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> returnListUser() {
        return this.userDao.returnListUser();
    }
}
