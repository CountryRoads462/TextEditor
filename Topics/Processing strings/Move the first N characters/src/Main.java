import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] splitUserInput = userInput.split(" ");
        int number = Integer.parseInt(splitUserInput[splitUserInput.length - 1]);
        for (int i = 0; i < splitUserInput.length - 1; i++) {
            result.append(splitUserInput[i]).append(" ");
        }
        result = result.deleteCharAt(result.length() - 1);
        if (result.length() < number) {
            System.out.println(result);
        } else {
            String firstSubstring = result.substring(number);
            String secondSubstring = result.substring(0, number);
            System.out.println(firstSubstring + secondSubstring);
        }
    }
}