package dao;

import Utils.HibernateUtils;
import entity.Transfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TransferDao {
    public void saveTransfer(Transfer transfer){

        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction transaction=null;
        try{
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            //业务逻辑代码
            session.save(transfer);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
