package dao;

import Utils.HibernateUtils;
import entity.Expenses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ExpensesDao {
    public void saveExpenses(Expenses expenses){

        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(expenses);
        session.close();
        sessionFactory.close();
    }
    public  void deleteExpenses(Expenses expenses){
        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.delete(expenses);
    }
}
