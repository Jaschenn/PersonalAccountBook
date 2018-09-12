package entity;

import java.util.Date;

public class Expenses {
    private String uid;     //唯一索引 （主键）
    private Date time;    //时间
    private double amount;  //价格
    private String type;    //支出种类
    private String account; //付款账户
    private boolean status; //0为已经支付，1为没有支付

    private String introduction;//说明


    public Expenses() {
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "uid='" + uid + '\'' +
                ", time='" + time + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", account='" + account + '\'' +
                ", status=" + status +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public Expenses(Date time, double amount, String type, String account, boolean status, String introduction) {
        this.time = time;
        this.amount = amount;
        this.type = type;
        this.account = account;
        this.status = status;
        this.introduction = introduction;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }



    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
