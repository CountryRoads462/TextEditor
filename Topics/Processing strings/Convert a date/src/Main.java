import java.util.Scanner;

class Main {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        String[] array = date.split("-");
        System.out.printf("%s/%s/%s", array[ONE], array[TWO], array[ZERO]);
    }
}