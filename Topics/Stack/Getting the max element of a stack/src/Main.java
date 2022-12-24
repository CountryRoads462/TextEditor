import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Stack<Integer> stackOfMax = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String command = scanner.nextLine();
            switch (command) {
                case "pop":
                    int lastNumber = stack.pop();
                    if (lastNumber == stackOfMax.peek()) {
                        stackOfMax.pop();
                    }
                    break;
                case "max":
                    System.out.println(stackOfMax.peek());
                    break;
                default:
                    int number = Integer.parseInt(command.split(" ")[1]);
                    if (!stackOfMax.empty()) {
                        if (number >= stackOfMax.peek()) {
                            stackOfMax.push(number);
                        }
                    } else {
                        stackOfMax.push(number);
                    }
                    stack.push(number);
                    break;
            }
        }
    }
}