import java.util.*;

public class Main {
    public static String result = "";
    public static int lastIndex = 0;
    public static int i = lastIndex;

    public static void firstStep(int a) {
        if (a > 0) {
            result += 'A';
            for (i = 1; i < a; i++) {
                switch (result.charAt(i - 1)) {
                    case 'A':
                        result += 'B';
                        break;
                    case 'B':
                        result += 'A';
                        break;
                    default:
                        break;
                }
                if (i == a - 1) {
                    lastIndex = i;
                }
            }
        }
    }

    public static void secondStep(int a, int b) {
        if (b > 0) {
            lastIndex++;
            result += 'a';
            for (i = lastIndex; i < a + b; i++) {
                switch (result.charAt(i - 1)) {
                    case 'a':
                        result += 'b';
                        break;
                    case 'b':
                        result += 'a';
                        break;
                    default:
                        break;
                }
                if (i == a + b - 1) {
                    lastIndex = i;
                }
            }
        }
    }

    public static void thirdStep(int a, int b, int c) {
        if (c > 0) {
            lastIndex++;
            result += '1';
            for (i = lastIndex; i < a + b + c; i++) {
                switch (result.charAt(i - 1)) {
                    case '1':
                        result += '2';
                        break;
                    case '2':
                        result += '1';
                        break;
                    default:
                        break;
                }
                if (i == a + b + c - 1) {
                    lastIndex = i;
                }
            }
        }
    }

    public static void fourthStep(int a, int b, int c, int d) {
        if (d - a - b - c > 0) {
            lastIndex++;
            result += 'd';
            for (i = lastIndex; i < d; i++) {
                switch (result.charAt(i - 1)) {
                    case 'd':
                        result += 'r';
                        break;
                    case 'r':
                        result += 'd';
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        firstStep(a);
        secondStep(a, b);
        thirdStep(a, b, c);
        fourthStep(a, b, c, d);

        System.out.print(result);
    }
}