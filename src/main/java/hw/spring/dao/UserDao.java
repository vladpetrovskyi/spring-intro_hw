package hw.spring.dao;

import hw.spring.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    Optional<User> getById(Long id);
}
