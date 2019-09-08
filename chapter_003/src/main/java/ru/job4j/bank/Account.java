package ru.job4j.bank;

public class Account {
    private long money;
    private String requisites;

    public Account(long money, String requisites) {
        this.money = money;
        this.requisites = requisites;
    }

    public String getRequisites() {
        return requisites;
    }

    public long getMoney() {
        return money;
    }

    protected boolean transfer(Account destAcc, long amount) {
        boolean success = false;
        if (amount > 0 && amount < this.money && destAcc != null) {
            success = true;
            this.money -= amount;
            destAcc.money += amount;
        }
        return success;
    }
}
