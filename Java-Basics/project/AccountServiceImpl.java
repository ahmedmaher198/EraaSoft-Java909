package service;

import model.Account;
import model.EWalletSystem;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    private EWalletSystem eWalletSystem = new EWalletSystem();

    @Override
    public boolean createAccount(Account account) {
        boolean isExit = eWalletSystem.getAccounts().stream().anyMatch(acc -> acc.getUsername().equals(account.getUsername()));
        boolean phonenumberIsExist = eWalletSystem.getAccounts().stream().anyMatch(acc -> acc.getPhonenumber().equals(account.getPhonenumber()));
        if (isExit || phonenumberIsExist) {
            return false;
        }
        eWalletSystem.getAccounts().add(account);
        return true;

    }

    @Override
    public boolean getAccount(Account account) {
        return eWalletSystem.getAccounts().stream().anyMatch(acc -> acc.getUsername().equals(account.getUsername())) &&
                eWalletSystem.getAccounts().stream().anyMatch(acc -> acc.getPassword().equals(account.getPassword()));

    }

    @Override
    public Integer deposit(Account account, double amount) {
        boolean isExist = eWalletSystem.getAccounts().stream().anyMatch(acc -> acc.getUsername().equals(account.getUsername()));
        if (!isExist) {
            return 1;
        }
        if (amount < 100) {
            return 2;
        }

        Optional<Account> optionalAccount = eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getUsername().equals(account.getUsername())).findFirst();
        Account accountToDeposit = optionalAccount.get();
        accountToDeposit.setBalance(accountToDeposit.getBalance() + amount);
        return 3;

    }

    @Override
    public Account getAccountByUsernameOnly(Account account) {
        boolean isExit = eWalletSystem.getAccounts().stream().anyMatch(acc -> acc.getUsername().equals(account.getUsername()));
        if (!isExit) {
            return null;
        }
        Optional<Account> optionalAccount = eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getUsername().equals(account.getUsername())).findFirst();
        return optionalAccount.get();
    }

    @Override
    public Integer withdraw(Account account, double amount) {
        boolean isExit = eWalletSystem.getAccounts().stream().anyMatch(acc -> acc.getUsername().equals(account.getUsername()));
        if (!isExit) {
            return 1;
        }
        if (amount < 100) {
            return 2;
        }
        Optional<Account> optionalAccount = eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getUsername().equals(account.getUsername())).findFirst();
        Account accountToWithdraw = optionalAccount.get();
        if (accountToWithdraw.getBalance() < amount) {
            return 3;
        }
        accountToWithdraw.setBalance(accountToWithdraw.getBalance() - amount);
        return 4;
    }

    @Override
    public Account isAccountExistByUsername(String username) {
        Optional<Account> optionalAccount = eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getUsername().equals(username))
                .findFirst();

        return optionalAccount.orElse(null);
    }

    @Override
    public Account isAccountExistByPhonenumber(String phonenumber) {
        Optional<Account> optionalAccount = eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getPhonenumber().equals(phonenumber))
                .findFirst();

        return optionalAccount.orElse(null);
    }

    @Override
    public boolean passwordMatching(Account account, String oldPassword) {
        if(account.getPassword().equals(oldPassword)){
            return true;
        }
        return false;
    }

    @Override
    public void updatePassword(Account account,String newPassword){
        account.setPassword(newPassword);
    }


}











