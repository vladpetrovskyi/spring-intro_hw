package hw.spring.dao;

import hw.spring.model.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.openSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        Query<User> query = sessionFactory.openSession()
                .createQuery("from User", User.class);
        return query.list();
    }
}
