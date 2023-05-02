package main.java;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoleDAOImpl implements RoleDAO {

    /**
     * Добавлять нового пользователя с ролями в БД;
     */
    @Override
    public void createNewRole(Role role) {
        try (Session session = HibernateFactorySessionUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        }
    }

/**
    Найти роль по ID
*/
    @Override
    public Role getRoleByID(int id) {
        return HibernateFactorySessionUtil.getSessionFactory().openSession().get(Role.class, id);
    }

    /**
     Найти роль по названию
     */
    @Override
    public Role getRoleByName(String name) {
        return HibernateFactorySessionUtil.getSessionFactory().openSession().get(Role.class, name);
    }

    /**
     Удалить роль
     */
    @Override
    public void deleteRole(Role role) {
        try (Session session = HibernateFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
        }
    }
}
