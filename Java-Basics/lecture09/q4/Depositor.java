package task2;

public class Depositor extends Thread{
    private BankAccount bankAccount;

    public Depositor(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    @Override
    public void run(){
        try {
            while (true){
                int amount = 100;
                bankAccount.deposit(amount);
                Thread.sleep(1000);
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



}
