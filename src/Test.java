import com.alibaba.fastjson.JSON;
import dao.AccountDao;
import entity.Account;

import java.util.ArrayList;


public class Test {

    public static void main(String[] args){
       AccountDao accountDao = new AccountDao();
        //测试添加账户
        Account account= new Account(5,"徐中枢");
        String balance="5";
        String accountname="!@#$%^&*(";
        accountDao.save(new Account(Double.parseDouble(balance),accountname));
//        // 测试加载全部账户
//        ArrayList arrayList=accountDao.loadAccount();
//        String jsonList = JSON.toJSONString(arrayList);
//        System.out.println(jsonList);
//       for(int i=0;i<arrayList.size();i++){
//           Account account=(Account) arrayList.get(i);
//           System.out.println(account.toString());
//       }


    }


}
