package main.java;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class UserDAOImpl implements UserDAO {

/**
    Добавлять нового пользователя с ролями в БД;
*/
    @Override
    public void create(User user) {
        try (Session session = HibernateFactorySessionUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    /**
     Получать список пользователей по ID;
     */
    @Override
    public User getuserByID(int id) {
        return HibernateFactorySessionUtil.getSessionFactory().openSession().get(User.class, id);
    }
    /**
     Получать список пользователей по конкретной роли;
     */
    @Override
    public List<User> getUsersByRole(Role role) {
        List<User> users = (List<User>) HibernateFactorySessionUtil.getSessionFactory()
                .openSession().createQuery("SELECT id FROM User WHERE roles = :role");
        return users;
    }
/**
    Получать список пользователей из БД (без ролей);
*/
    @Override
    public List<User> getEveryone() {
        List<User> users = (List<User>) HibernateFactorySessionUtil.getSessionFactory()
                .openSession().createQuery("FROM User").list();

        return users;
    }

    /**
     Редактировать существующего пользователя в БД.
     */
    @Override
    public void updatePersonById(User user) {
        try (Session session = HibernateFactorySessionUtil.getSessionFactory().openSession()) {
    Transaction transaction = session.beginTransaction();
            user.setTimeOfModification(new Date());
            session.update(user);
            transaction.commit();
        }
    }
    /**
     Удалять пользователя в БД;
     */
    @Override
    public void deleteUser(User user) {
        try (Session session = HibernateFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }

    }
}
