import Utils.FileWRUtils;
import com.alibaba.fastjson.JSON;
import dao.AccountDao;
import dao.ExpensesDao;
import entity.Account;
import entity.Expenses;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.*;


public class Test {

    public static void main(String[] args){
          ExpensesDao expensesDao = new ExpensesDao();


          ArrayList<Expenses> daoexpenses=expensesDao.loadExpenses();
//            FileWRUtils.setFilename("tet3.txt");
//            Expenses expenses1 = expenses.get(0);
//            FileWRUtils.setObject(expenses1);
//            FileWRUtils.JfileWriter();

//        ArrayList<Expenses> expenses = new ArrayList<>();
//        Expenses expenses1= new Expenses();
//        Expenses expenses2 = new Expenses();
//        expenses.add(expenses1);
//        expenses.add(expenses2);

        FileWRUtils.setFilename("9手动创建list.txt");
        for(int i=0;i<daoexpenses.size();i++){

            FileWRUtils.setObject(daoexpenses.get(i));

            FileWRUtils.JfileWriter();
        }


//        Expenses eexpenses=new Expenses();
//        eexpenses.setIntroduction("121");
//        eexpenses.setType("212");
//        FileWRUtils.setObject(eexpenses);
//        FileWRUtils.setFilename("1.txt");
//        FileWRUtils.JfileWriter();

//        Expenses wexpenses=new Expenses();
//        expenses.setIntroduction("sss");
//        expenses.setType("ss");
//        FileWRUtils.setObject(wexpenses);
//        FileWRUtils.setFilename("12534567.txt");
//        FileWRUtils.JfileWriter();


    }


}
