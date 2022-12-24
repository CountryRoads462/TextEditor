import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        for (char ch :
                userInput.toCharArray()) {
            System.out.print(ch + "" + ch);
        }
    }
}