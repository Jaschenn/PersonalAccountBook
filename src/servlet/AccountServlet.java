package servlet;


import dao.AccountDao;
import entity.Account;

import java.io.IOException;

public class AccountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String method=request.getParameter("AccountMethod");
        System.out.println(method);
        saveAccount(request,response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doPost(request,response);

    }

   public void saveAccount(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        String accountname = request.getParameter("InputAccountName");
        String balance = request.getParameter("InputBalance");
        AccountDao accountDao = new AccountDao();
        accountDao.save(new Account(Double.parseDouble(balance),accountname));
    }
    public void deleteAccount(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        System.out.println("开始删除数据");
    }
}
