package servlet;

import com.alibaba.fastjson.JSON;
import dao.IncomeDao;
import entity.Income;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "IncomeServlet")
public class IncomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String IncomeMethod = request.getParameter("IncomeMethod");
        if ("saveIncome".equals(IncomeMethod)){
            saveIncome(request,response);
        }else if("loadIncome".equals(IncomeMethod)){
            String IncomeData = loadIncome();
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(IncomeData);
            out.flush();
            System.out.println(IncomeData);


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void saveIncome(HttpServletRequest request, HttpServletResponse response){
        String accountUid = request.getParameter("accountUid");
        String IncomeSource=request.getParameter("IncomeSource");
        String IncomeAmount=request.getParameter("IncomeAmount");
        Income income = new Income();
        income.setAmount(Double.parseDouble(IncomeAmount));
        income.setAccountUuid(accountUid);
        income.setSource(IncomeSource);
        income.setTime(new Date());
        IncomeDao incomeDao = new IncomeDao();
        incomeDao.saveIncome(income);

    }

    public String loadIncome(){
        IncomeDao incomeDao = new IncomeDao();
        ArrayList<Income> expenses = incomeDao.loadIncome();

        return JSON.toJSONString(expenses);
    }
}
