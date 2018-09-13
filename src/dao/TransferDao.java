package dao;

import Utils.HibernateUtils;
import entity.Account;
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
            AccountDao accountDao = new AccountDao();
            Account account1 = new Account();
            Account account2 = new Account();
            account1.setUuid(transfer.getFromAccount());
            account2.setUuid(transfer.getToAccount());
            session.save(transfer);

            account1=session.get(Account.class,transfer.getFromAccount());
            account2=session.get(Account.class,transfer.getToAccount());
            account1.setBalance(account1.getBalance()-transfer.getNumber());
            account2.setBalance((account2.getBalance()+(transfer.getNumber())));
            session.update(account1);
            session.update(account2);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
