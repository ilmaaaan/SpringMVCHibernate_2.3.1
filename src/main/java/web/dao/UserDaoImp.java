package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(sessionFactory.getCurrentSession().merge(user));
    }

    @Override
    public List<User> getUsers() {
           TypedQuery<User> query =  sessionFactory.getCurrentSession().createQuery("from User", User.class);
           return query.getResultList();
    }
}
