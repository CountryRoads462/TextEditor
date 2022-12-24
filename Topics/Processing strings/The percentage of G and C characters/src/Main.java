import java.util.Scanner;

class Main {
    public static final double HUNDRED = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double g = 0;
        double c = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'g' || input.charAt(i) == 'G') {
                g++;
            }
            if (input.charAt(i) == 'c' || input.charAt(i) == 'C') {
                c++;
            }
        }

        double result = ((g + c) / input.length()) * HUNDRED;
        System.out.print(result);
    }
}