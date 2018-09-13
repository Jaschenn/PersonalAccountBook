package servlet;

import Utils.DateUtils;
import Utils.FileWRUtils;
import com.alibaba.fastjson.JSON;
import dao.AccountDao;
import dao.ExpensesDao;
import entity.Account;
import entity.Expenses;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ExpensesServlet")
public class ExpensesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String ExpensesMethod=request.getParameter("ExpensesMethod");
    System.out.println("ExpensesMethod:"+ExpensesMethod);
    if("saveExpenses".equals(ExpensesMethod)){
        saveExpenses(request,response);
    }else if("loadExpenses".equals(ExpensesMethod)){
        String ExpensesData = loadExpenses();
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(ExpensesData);
        out.flush();
        System.out.println(ExpensesData);
    }else if ("exportBills".equals(ExpensesMethod)){
        System.out.println("账单导出开始");
        try {
            ExpensesDao expensesDao = new ExpensesDao();
            ArrayList<Expenses> expenses=expensesDao.loadExpenses();
            FileWRUtils.setFilename("bills.txt");
            FileWRUtils.JfileWriter(expenses);
            //expensesDao.exportBills("bills.txt", expensesDao.loadExpenses());
          //  Expenses expenses=new Expenses();
           // FileWRUtils.setObject(expenses);
           // FileWRUtils.JfileWriter();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("导出成功");
    }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
    public void saveExpenses(HttpServletRequest request, HttpServletResponse response){
        //保存消费
        ExpensesDao expensesDao = new ExpensesDao();
        Expenses expenses=new Expenses();

        String account=request.getParameter("expensesAccount");
        Double amount=Double.parseDouble(request.getParameter("expensesAmount"));
        String introduction=request.getParameter("introduction");
        String type=request.getParameter("expensesType");
        String uid=request.getParameter("accountuuid");
        Date time=null;

        try {
             time = DateUtils.parse(request.getParameter("expensesTime"));
        }catch (Exception e){
            e.printStackTrace();
        }

        expenses.setAccount(account);
        expenses.setAmount(amount);
        expenses.setTime(time);
        expenses.setType(type);
        expenses.setIntroduction(introduction);
        expensesDao.saveExpenses(expenses);
        try {
            Account objaccount = new Account();
            AccountDao accountDao = new AccountDao();
            objaccount.setUuid(uid);
            Account resultAccount = accountDao.getAccount(objaccount);
            System.out.println();
            resultAccount.setBalance(resultAccount.getBalance()-amount);
           // objaccount.setBalance(resultAccount.getBalance() - amount);
            System.out.println("修改之后的余额："+resultAccount.getBalance());
            accountDao.updateAccount(resultAccount);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String loadExpenses(){
        ExpensesDao expensesDao = new ExpensesDao();
        ArrayList<Expenses> expenses = expensesDao.loadExpenses();

        return JSON.toJSONString(expenses);
    }


}
