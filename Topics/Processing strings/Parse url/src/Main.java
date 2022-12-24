import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = "";
        String input = scanner.nextLine();
        String newInput = input.replace("https://target.com/index.html?", "");
        String[] array = newInput.split("&");
        for (String s : array) {
            String[] elem = s.split("=");
            switch (elem.length) {
                case 1:
                    System.out.printf("%s : not found\n", elem[0]);
                    break;
                case 2:
                    System.out.printf("%s : %s\n", elem[0], elem[1]);
                    break;
                default:
                    break;
            }
            if (Objects.equals(elem[0], "pass")) {
                password = elem[1];
            }
        }
        if (!Objects.equals(password, "")) {
            System.out.printf("password : %s", password);
        }
    }
}