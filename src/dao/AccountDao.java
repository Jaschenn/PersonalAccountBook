package dao;

import Utils.HibernateUtils;
import entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountDao {
    public void save(Account account){

        SessionFactory sessionFactory =HibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.save(account);
        Transaction transaction=session.beginTransaction();
        transaction.commit();
        session.close();
        sessionFactory.close();


    }
    public void delete(Account account){

        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.delete(account);
        session.close();
        sessionFactory.close();

    }
}
