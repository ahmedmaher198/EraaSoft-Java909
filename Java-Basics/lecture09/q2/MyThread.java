package task2;

public class MyThread extends Thread{
    @Override
    public void run(){
        for (int i = 0;i<5;i++){
            System.out.println(i+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
