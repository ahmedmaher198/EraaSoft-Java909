public class Task3 {

    public static void convertToUpper(String text) {
        try {
            String result = text.toUpperCase();
            System.out.println("Uppercase: " + result);
        } catch (NullPointerException e) {
            System.out.println("Cannot convert to uppercase because the value is null!");
        }
    }

    public static void main(String[] args) {
        convertToUpper(null);
    }
}
