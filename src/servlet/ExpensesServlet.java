package servlet;

import Utils.DateUtils;
import com.alibaba.fastjson.JSON;
import dao.ExpensesDao;
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

    }

    public String loadExpenses(){
        ExpensesDao expensesDao = new ExpensesDao();
        ArrayList<Expenses> expenses = expensesDao.loadExpenses();

        return JSON.toJSONString(expenses);
    }
}
