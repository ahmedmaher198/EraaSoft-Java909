package model;

public class Account {
    private String username;
    private String password;
    private int age;
    private double balance;
    private String phonenumber;


public Account (){
}

public Account(String username,String password){
    this.username = username;
    this.password = password;
    balance=0;
}

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
