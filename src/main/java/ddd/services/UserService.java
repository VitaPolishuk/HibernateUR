package ddd.services;

import ddd.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    public void addUser(User user);

    public void changeUser(User user);

    public void deleteUser(int id);

    public User getUserById(int id);

    public List<User> returnListUser();
}
