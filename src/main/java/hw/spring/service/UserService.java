package hw.spring.service;

import hw.spring.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long id);
}
