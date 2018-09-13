package servlet;

import Utils.HibernateUtils;
import dao.TransferDao;
import entity.Transfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "TransferServlet")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TransferMethod=request.getParameter("TransferMethod");
        System.out.println("=========TransferMethod====="+TransferMethod);
        if("saveTransfer".equals(TransferMethod)){
            saveTransfer(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void saveTransfer(HttpServletRequest request, HttpServletResponse response){

        String fromAccunt =request.getParameter("fromAccount");
        String toAccount = request.getParameter("toAccount");
        Double number = Double.parseDouble(request.getParameter("transferNumber"));
        System.out.println("进入到saveTransfer");
        Transfer transfer = new Transfer();
        TransferDao transferDao = new TransferDao();
        try {
            transfer.setNumber(number);
            transfer.setFromAccount(fromAccunt);
            transfer.setToAccount(toAccount);
            transfer.setDate(new Date());//转账时间设置为系统当前时间
            System.out.println("transfer账户设置成功");
            transferDao.saveTransfer(transfer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
