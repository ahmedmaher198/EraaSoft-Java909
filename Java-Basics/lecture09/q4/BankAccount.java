package task2;

public class BankAccount {
    private int account;

    public synchronized void deposit(int x){
        account = account + x;
        notify();
    }

    public void withdraw(int x){
        if (x>account){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            account = account - x;
        }
    }
}
