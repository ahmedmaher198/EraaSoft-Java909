import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the first integer");
        int x = scanner.nextInt();
        System.out.println("enter the second integer");
        int y = scanner.nextInt();
        try {
            int z = x/y;
            System.out.println("the result is "+ z);
        } catch (ArithmeticException e) {
            System.out.println("can not divide by zero");
        }


    }
}