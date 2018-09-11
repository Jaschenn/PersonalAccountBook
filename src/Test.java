import Utils.FileWRUtils;
import com.alibaba.fastjson.JSON;
import dao.AccountDao;
import entity.Account;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Test {

    public static void main(String[] args){
//       AccountDao accountDao = new AccountDao();
//        //测试添加账户
//        Account account= new Account(5,"徐中枢");
//        String balance="5";
//        String accountname="!@#$%^&*(";
//        accountDao.save(new Account(Double.parseDouble(balance),accountname));
//        // 测试加载全部账户
//        ArrayList arrayList=accountDao.loadAccount();
//        String jsonList = JSON.toJSONString(arrayList);
//        System.out.println(jsonList);
//       for(int i=0;i<arrayList.size();i++){
//           Account account=(Account) arrayList.get(i);
//           System.out.println(account.toString());
//       }

      //  for(int i=0;i<10;i++) {

            Account account = new Account("123",12, "zz");
            FileWRUtils.setFilename("data.txt");
            FileWRUtils.setObject(account);
            FileWRUtils.JfileReader();  //从文件中读取数据



          //  FileWRUtils.JfileWriter(); //向文件中写数据

     //   }
        //测试objectOutputStream
//        ObjectOutputStream oos;
//        try{
//            oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("oos.txt",true)));
//            oos.writeObject(account);
//            oos.flush();
//            oos.close();
//        }catch(Exception e){
//           e.printStackTrace();
//        }finally {
//
//        }
    }


}
