package dao;

import Utils.HibernateUtils;
import entity.Account;
import entity.Income;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class IncomeDao {
    public void saveIncome(Income income){
        SessionFactory sessionFactory= HibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            //保存收入,业务逻辑啊代码

            System.out.println("====保存收入====");
            System.out.println("====保存收入====");
            System.out.println("====保存收入====");
            System.out.println("====保存收入====");
            Account account=session.get(Account.class,income.getAccountUuid());
            account.setBalance(income.getAmount()+account.getBalance());
            income.setAccountName(session.get(Account.class,income.getAccountUuid()).getAccountname());
            session.update(account);
            session.save(income);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
    public ArrayList<Income> loadIncome(){
        //加载所有的支出
        ArrayList<Income> expenses = new ArrayList<>();
        SessionFactory sessionFactory = null;
        Session session = null;
        try{
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //业务逻辑代码
            Criteria criteria=session.createCriteria(Income.class);
            expenses=(ArrayList<Income>)criteria.list();
            transaction.commit();
        }catch(Exception e){

            System.out.println("异常"+e.getMessage());

        }finally {

            session.close();
//          sessionFactory.close();
        }

        return expenses;
    }
}
