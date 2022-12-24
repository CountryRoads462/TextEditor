import java.util.Scanner;

class Main {
    public static final int THREE = 3;
    public static final int TEN = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i < THREE) {
                sum1 += Character.digit(input.charAt(i), TEN);
            } else {
                sum2 += Character.digit(input.charAt(i), TEN);
            }
        }

        System.out.println(sum1 == sum2 ? "Lucky" : "Regular");
    }
}