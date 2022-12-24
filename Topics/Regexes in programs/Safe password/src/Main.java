import java.nio.file.Paths;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "(.*\\d.*[a-z].*[A-Z].*)|(.*\\d.*[A-Z].*[a-z].*)|(.*[a-z].*\\d.*[A-Z].*)|(.*[a-z].*[A-Z].*\\d.*)|(.*[A-Z].*[a-z].*\\d.*)|(.*[A-Z].*\\d.*[a-z].*)";
        String userInput = scanner.nextLine();
        if (userInput.length() >= 12 && userInput.matches(regex)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}