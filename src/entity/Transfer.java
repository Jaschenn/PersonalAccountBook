package entity;

import java.util.Date;

public class Transfer {
    private String uuid;
    private String fromAccount;
    private String toAccount;
    private Date date;
    private double number;
    public void Transfer(Account fromAccount,Account toAccount,Date date,double number){
        this.date=date;
        this.fromAccount=fromAccount.getAccountname();
        this.toAccount=toAccount.getAccountname();
        this.number=number;
    }

    public Transfer() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
