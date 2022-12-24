import java.util.Scanner;

class Main {
    public static final int FOUR = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = new String[FOUR];
        int i;
        for (i = 0; i < FOUR; i++) {
            array[i] = scanner.next();
        }
        for (i = 0; i < FOUR; i++) {
            System.out.println(array[i]);
        }
    }
}