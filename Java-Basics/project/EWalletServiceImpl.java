package service;

import model.Account;

import java.util.Objects;
import java.util.Scanner;

public class EWalletServiceImpl implements ApplicationService {
    private AccountService accountService = new AccountServiceImpl();
    private AccountValidationService accountValidationService = new AccountValidationServiceImp();

    @Override
    public void startApp() {
        System.out.println("hello sir");
        int counter = 0;
        Boolean isExit = false;

        while (true) {
            System.out.println("please enter you service");
            System.out.println("a-login     b-sign up          c-exit");
            Scanner scanner = new Scanner(System.in);
            char service = scanner.next().charAt(0);
            switch (service) {
                case 'a':
                    loginService();
                    break;

                case 'b':
                    signUp();
                    break;
                case 'c':
                    System.out.println("thank you ");
                    isExit = true;
                    break;
                default:
                    System.out.println("invalid choose");
                    counter++;

            }
            if (isExit) {
                break;
            }
            if (counter == 3) {
                System.out.println("please contact with admin");
                break;
            }

        }


    }


    public void loginService() {
        System.out.println("please enter username");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("please enter password");
        String password = scanner.nextLine();
        Account account = new Account(username, password);
        if (accountService.getAccount(account)) {
            System.out.println("login sucess");
            profile(account);
        } else {
            System.out.println("invalid username");
        }

    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        int age;
        String phonenumber;
        while (true) {
            System.out.println("please enter username");
            username = scanner.nextLine();
            if (accountValidationService.usernameValidation(username)) {
                break;
            }
        }
        while (true) {
            System.out.println("please enter password");
            password = scanner.nextLine();
            if(accountValidationService.passwordValidation(password)){
                break;
            }
        }
        while (true) {
            try {
                System.out.println("please enter age");
                age = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                if (accountValidationService.ageValidation(age)) {
                    break;
                }
            } catch (RuntimeException e) {
                System.out.println("age must be a number");
                scanner.nextLine(); // مهم جدًا
            }
        }

        while (true) {
            System.out.println("enter phone number");
            phonenumber = scanner.nextLine();
            if (accountValidationService.phonenumberValidation(phonenumber)){
                break;
            }
        }

        Account account = new Account(username, password);
        account.setPhonenumber(phonenumber);
        account.setAge(age);
        boolean isAccountCreated = accountService.createAccount(account);
        if (isAccountCreated) {
            System.out.println("congratulations your account is sucssefully created");
            profile(account);
        } else {
            System.out.println("account is already created");
        }
    }

    private void profile(Account account) {
        int counter = 0;
        boolean logout = false;
        while (true) {
            try {
                System.out.println("welcome sir to main profile page");
                System.out.println("please enter service you want");
                System.out.println("1-deposit      2-withdraw       3-transfer     4-show account details      5-change password    6-logout");
                Scanner scanner = new Scanner(System.in);
                int service = scanner.nextInt();
                switch (service) {
                    case 1:
                        deposit(account);
                        break;
                    case 2:
                        withdraw(account);
                        break;
                    case 3:
                        transfer(account);
                        break;
                    case 4:
                        showAccountDetails(account);
                        break;
                    case 5:
                        changePassword(account);
                        break;

                    case 6:
                        System.out.println("have a nice day");
                        logout = true;
                        break;
                    default:
                        System.out.println("invalid service");
                        counter++;
                }

            } catch (RuntimeException e) {
                System.out.println("service you want not available");

            }


            if (logout) {
                break;
            }
            if (counter == 3) {
                System.out.println("please contact with admin");
            }

        }
    }

    private void deposit(Account account) {
        while (true) {
            try {
                System.out.println("enter the value you want to deposit");
                Scanner scanner = new Scanner(System.in);
                double amount = scanner.nextDouble();
                Integer isDeposited = accountService.deposit(account, amount);
                if (isDeposited == 3) {
                    System.out.println("deposit success");
                    System.out.println("available now " + account.getBalance());
                } else if (isDeposited == 2) {
                    System.out.println("deposit fail the amount must be greater than 100");
                } else {
                    System.out.println("account not exit");
                }
                break;
            } catch (RuntimeException e) {
                System.out.println("the value you want to deposit should be number");
            }
        }

    }

    private void showAccountDetails(Account account) {
        Account accountExit = accountService.getAccountByUsernameOnly(account);
        if (Objects.isNull(accountExit)) {
            System.out.println("account not exit");
            return;
        }
        System.out.println(" -----------> account details <--------------");
        System.out.println(account);

    }
    private void withdraw(Account account) {
        while (true) {
            try {
                System.out.println("please enter the value you want to withdraw");
                Scanner scanner = new Scanner(System.in);
                double amount = scanner.nextDouble();
                Integer isWithdraw = accountService.withdraw(account, amount);
                if (isWithdraw == 1) {
                    System.out.println("account not exit");
                } else if (isWithdraw == 2) {
                    System.out.println("deposit fail the amount must be greater than 100");

                } else if (isWithdraw == 3) {
                    System.out.println("the value you enter is grater than your money in account");
                } else {
                    System.out.println("withdraw success");
                    System.out.println("available now " + account.getBalance());
                }
                break;
            } catch (RuntimeException e) {
                System.out.println("the value you want to withdraw should be number");

            }
        }
    }
    private void transfer(Account account) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            try {
                System.out.println("transfer by:");
                System.out.println("1- username");
                System.out.println("2- phone number");

                choice = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (RuntimeException e) {
                System.out.println("choise you enter is not available");
            }
        }

        Account receiver = null;

        while (receiver == null) {

            if (choice == 1) {
                System.out.println("enter username:");
                String username = scanner.nextLine();
                receiver = accountService.isAccountExistByUsername(username);

            } else if (choice == 2) {
                System.out.println("enter phone number:");
                String phone = scanner.nextLine();
                receiver = accountService.isAccountExistByPhonenumber(phone);

            } else {
                System.out.println("invalid choice");
                return;
            }

            if (receiver == null) {
                System.out.println("this account not exist");
            }
        }
        double amount;
        while (true){
            try {
                System.out.println("enter amount:");
                amount = scanner.nextDouble();
                break;
            } catch (RuntimeException e) {
                System.out.println("amount should be number");
                scanner.nextLine();
            }

        }
        int withdrawStatus = accountService.withdraw(account, amount);
        //System.out.println("available now " + account.getBalance());

        if (withdrawStatus == 2) {
            System.out.println("amount must be greater than 100");
            return;
        }

        if (withdrawStatus == 3) {
            System.out.println("insufficient balance");
            return;
        }

        accountService.deposit(receiver, amount);

        System.out.println("transfer success");
        System.out.println("available now " + account.getBalance());
    }

    public void changePassword(Account account) {
        while (true) {
            System.out.println("please enter your old password");
            Scanner scanner = new Scanner(System.in);
            String oldPassword = scanner.nextLine();
            if (accountService.passwordMatching(account, oldPassword)) {
                while (true) {
                    System.out.println("please enter the new password");
                    String newPassword = scanner.nextLine();
                    if (accountValidationService.passwordValidation(newPassword)) {
                        accountService.updatePassword(account, newPassword);
                        System.out.println("The password has been changed successfully. ✅");
                        break;
                    }
                }
                break;
            } else {
                System.out.println("the password you enter not correct");
            }

        }
    }
}