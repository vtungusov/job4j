package ru.job4j.bank;

import java.util.*;

public class Bank {
    private final Map<User, List<Account>> clients = new TreeMap<>();

    public void addUser(User user) {
        this.clients.put(user, this.getAccList());
    }

    private List<Account> getAccList() {
        return new ArrayList<>(0);
    }

    public void deleteUser(User user) {
        this.clients.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.clients.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.clients.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().remove(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = this.getAccList();
        for (Map.Entry<User, List<Account>> entry : this.clients.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                result = entry.getValue();
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account transFrom = getAccountByData(srcPassport, srcRequisite);
        Account transTo = getAccountByData(destPassport, destRequisite);
        if (transFrom != null && transTo != null && transFrom.getMoney() >= amount) {
            result = transFrom.transfer(transTo, (long) amount);
        }
        return result;
    }

    private Account getAccountByData(String passport, String requisite) {
        Account result = null;
        List<Account> accounts = this.getUserAccounts(passport);
        for (int i = 0; i != accounts.size(); i++) {
            if (accounts.get(i).getRequisites().equals(requisite)) {
                result = accounts.get(i);
                break;
            }
        }
        return result;
    }
}
