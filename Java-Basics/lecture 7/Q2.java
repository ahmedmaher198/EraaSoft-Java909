import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number ");
        try {
            String num = scanner.nextLine();
            int x = Integer.parseInt(num);
            System.out.println("the integer is "+x);
        } catch (NumberFormatException e) {
            System.out.println("the number is not true ");

        }






    }
}