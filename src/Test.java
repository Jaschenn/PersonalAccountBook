import dao.AccountDao;
import entity.Account;
public class Test {

    public static void main(String[] args){
        AccountDao accountDao = new AccountDao();
        Account account= new Account(1,"1");
        accountDao.save(account);


    }


}
