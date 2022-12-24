import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input += " ";
        String result = "";
        char[] array = input.toCharArray();
        int currentChar = array[0];
        int counter = 1;

        for (int i = 1; i < array.length; i++) {
            if (i == array.length - 1) {

            }
            if (array[i] == currentChar) {
                counter++;
            } else {
                result += String.format("%c%d", currentChar, counter);
                currentChar = array[i];
                counter = 1;
            }
        }

        if (array.length == 1) {
            System.out.printf("%c1", array[0]);
        } else {
            System.out.print(result);
        }
    }
}