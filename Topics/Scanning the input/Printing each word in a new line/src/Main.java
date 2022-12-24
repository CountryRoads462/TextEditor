import java.util.Scanner;

class Main {
    public static final int FIVE = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = new String[FIVE];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.next();
            System.out.println(array[i]);
        }
    }
}