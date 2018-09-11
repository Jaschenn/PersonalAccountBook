package dao;

import Utils.HibernateUtils;
import entity.Account;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class AccountDao {
    public void save(Account account){

        SessionFactory sessionFactory =HibernateUtils.getSessionFactory();
        Session session=null;
        Transaction transaction=null;
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        try{
            session.save(account);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }


    }
    public void delete(Account account){

        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(account);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
    public ArrayList<Account> loadAccount(){

        ArrayList<Account> accounts = new ArrayList<>();
        SessionFactory sessionFactory = null;
        Session session = null;
        try{
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //业务逻辑代码
            Criteria criteria=session.createCriteria(Account.class);
            accounts=(ArrayList<Account>)criteria.list();
            transaction.commit();
        }catch(Exception e){

            System.out.println(e.getMessage());

        }finally {

            session.close();
//            sessionFactory.close();
        }

        return accounts;
    }

}
