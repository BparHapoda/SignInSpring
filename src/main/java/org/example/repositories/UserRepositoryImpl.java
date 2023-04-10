package org.example.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private SessionFactory sessionFactory;


    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();

    }

    @Override
    public boolean isUser(String login) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User WHERE login=:login";
            Query<String> query = session.createQuery(hql, String.class);
            query.setParameter("login", login);
            List results = query.list();
            if (results.size() == 0) {
                return false;
            } else return true;
        }

    }

    @Override
    public String getPasswordByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User WHERE login=:login";
            Query query = session.createQuery(hql, User.class);
            query.setParameter("login", login);
            List <User> users = query.list();
            Iterator<User> item = users.iterator();
            User user = (User) item.next();
            return user.getPassword();

        }
    }
}
