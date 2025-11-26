import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) {
        int arr [] = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number of index ");
        try {
            int index = scanner.nextInt();
            System.out.println("the value of this index is "+arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("the index you enter is out of range ");
        }



    }
}