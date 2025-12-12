package task2;

public class Withdrawer extends Thread {

    private BankAccount account;

    public Withdrawer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int amount = 150;
                account.withdraw(amount);
                Thread.sleep(1200); // withdraw every 1.2 sec
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
