package entity;

import java.util.Date;

public class Income {
    private String uid;     //唯一索引 （主键）
    private Date time;    //时间
    private double amount;  //金额
    private String source;    //收入来源
    private String accountName; //入款账户名称
    private String accountUuid; //入款账户id

    public Income() {
    }

    public Income(Date time, double amount, String source, String accountName, String accountUuid) {
        this.time = time;
        this.amount = amount;
        this.source = source;
        this.accountName = accountName;
        this.accountUuid = accountUuid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }
}
