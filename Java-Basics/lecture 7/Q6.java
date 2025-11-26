import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the first number");
        int num1 = scanner.nextInt();
        System.out.println("enter the second number");
        int num2 = scanner.nextInt();
        scanner.nextLine(); // قراءة السطر الجديد المتبقي
        System.out.println("enter the string");
        String string = scanner.nextLine();


        try {
            int result = num1/num2;
            System.out.println("the result is "+result);
            String new_string = string.toUpperCase();
            System.out.println("the string is"+new_string);
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }



    }
}