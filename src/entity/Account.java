package entity;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable,Cloneable {
    private String uuid;            //唯一标志
    private double balance;         //余额
    private String accountname;     //账户名称

    public Account() {
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
}
