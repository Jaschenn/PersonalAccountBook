package dao;

import Utils.FileWRUtils;
import Utils.HibernateUtils;
import entity.Account;
import entity.Expenses;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class ExpensesDao {
    public void saveExpenses(Expenses expenses){

        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(expenses);
        transaction.commit();
        session.close();
    }

    public  void deleteExpenses(Expenses expenses){
        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(expenses);
        transaction.commit();
        session.close();
    }

    public ArrayList<Expenses> loadExpenses(){
        //加载所有的支出
        ArrayList<Expenses> expenses = new ArrayList<>();
        SessionFactory sessionFactory = null;
        Session session = null;
        try{
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //业务逻辑代码
            Criteria criteria=session.createCriteria(Expenses.class);
            expenses=(ArrayList<Expenses>)criteria.list();
            transaction.commit();
        }catch(Exception e){

            System.out.println("异常"+e.getMessage());

        }finally {

            session.close();
//          sessionFactory.close();
        }

        return expenses;
    }

    public void exportBills(String filename,ArrayList<Expenses> arrayList){

        for(int i=0;i<arrayList.size();i++){
            FileWRUtils.setObject((arrayList.get(i)));
            FileWRUtils.setFilename(filename);
            FileWRUtils.JfileWriter();
            break;
        }

    }

    public void transExpenses(){

    }
}
