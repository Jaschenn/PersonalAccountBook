package entity;

import java.io.Serializable;

public class Account implements Serializable,Cloneable {
    private String uuid;            //唯一标志
    private double balance;         //余额
    private String accountname;     //账户名称
    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "uuid='" + uuid + '\'' +
                ", balance=" + balance +
                ", accountname='" + accountname + '\'' +
                '}';
    }

    public Account(double balance, String accountname) {
        this.balance = balance;
        this.accountname = accountname;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public Account(String uuid, double balance, String accountname) {
        this.uuid = uuid;
        this.balance = balance;
        this.accountname = accountname;
    }
}
