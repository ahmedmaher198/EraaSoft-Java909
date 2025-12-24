package service;

import model.Account;

public interface AccountService {
    boolean createAccount(Account account);
    boolean getAccount(Account account);
    Integer deposit(Account account, double amount);
    Account getAccountByUsernameOnly(Account account);
    Integer withdraw(Account account,double amount);
    Account isAccountExistByUsername(String username);
    Account isAccountExistByPhonenumber(String phonenumber);
    boolean passwordMatching(Account account, String oldPassword);
    void updatePassword(Account account,String newPassword);


}
