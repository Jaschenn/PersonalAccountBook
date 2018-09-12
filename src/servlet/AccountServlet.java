package servlet;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import dao.AccountDao;
import entity.Account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AccountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String AccountMethod=request.getParameter("AccountMethod");
        System.out.println(AccountMethod);
        if ("saveAccount".equals(AccountMethod)){
            saveAccount(request,response);
        }else if ("loadAccount".equals(AccountMethod)){
            String AccountData = loadAccount();
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(AccountData);
            out.flush();
            System.out.println(AccountData);

        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doPost(request,response);

    }

    public void saveAccount(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        String accountname = request.getParameter("InputAccountName");
        String balance = request.getParameter("InputBalance");
        AccountDao accountDao = new AccountDao();
        System.out.println("===saveAccount===");
        System.out.println(balance);
        System.out.println(accountname);
        System.out.println("=================");
        accountDao.save(new Account(Double.parseDouble(balance),accountname));
    }
    public void deleteAccount(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        System.out.println("开始删除数据");
    }

    public String loadAccount(){
        AccountDao accountDao=new AccountDao();
        ArrayList<Account> accounts=null;
        accounts=accountDao.loadAccount();
        String str = JSON.toJSONString(accounts);

        return str;
    }


}
