package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class Bank {
    private final Map<User, List<Account>> clients = new TreeMap<>();

    public void addUser(User user) {
        this.clients.putIfAbsent(user, this.getAccList());
    }

    private List<Account> getAccList() {
        return new ArrayList<>(0);
    }

    public void deleteUser(User user) {
        this.clients.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        clients.entrySet().stream()
                .filter(e ->
                        e.getKey().getPassport().equals(passport))
                .forEach(acc ->
                        acc.getValue().add(account));

        /*for (Map.Entry<User, List<Account>> entry : this.clients.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().add(account);
            }
        }*/
    }

    public void deleteAccountFromUser(String passport, Account account) {
        clients.entrySet().stream()
                .filter(e ->
                        e.getKey().getPassport().equals(passport))
                .forEach(acc ->
                        acc.getValue().remove(account));

        /*for (Map.Entry<User, List<Account>> entry : this.clients.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().remove(account);
            }
        }*/
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result;
        result = clients.entrySet().stream()
                .filter(e ->
                        (e.getKey().getPassport().equals(passport)
                        ))
                .flatMap(e ->
                        e.getValue().stream())
                .collect(Collectors.toList());

        /*this.getAccList();
        for (Map.Entry<User, List<Account>> entry : this.clients.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                result = entry.getValue();
            }
        }*/
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Optional<Account> transFrom = getAccountByData(srcPassport, srcRequisite);
        Optional<Account> transTo = getAccountByData(destPassport, destRequisite);
        if (transFrom.isPresent()
                && transTo.isPresent()
                && transFrom.get().getMoney() >= amount) {
            result = transFrom.get().transfer(transTo.get(), (long) amount);
        }
        return result;
    }

    private Optional<Account> getAccountByData(String passport, String requisite) {

        Optional<Account> result;
        List<Account> accounts = this.getUserAccounts(passport);
        result = accounts.stream()
                .filter(account ->
                        account.getRequisites().equals(requisite))
                .findFirst();

        /*for (int i = 0; i != accounts.size(); i++) {
            if (accounts.get(i).getRequisites().equals(requisite)) {
                result = accounts.get(i);
                break;
            }
        }*/
        return result;
    }
}
