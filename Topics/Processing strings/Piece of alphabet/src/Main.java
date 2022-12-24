import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String englishAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String userInput = scanner.nextLine();
        if (englishAlphabet.contains(userInput)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}