import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("password[:\\s]+[A-Za-z0-9]+",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            Pattern pattern1 = Pattern.compile("[A-Za-z0-9]+$");
            Matcher matcher1 = pattern1.matcher(matcher.group());
            if (matcher1.find()) {
                System.out.println(matcher1.group());
            }
            while (matcher.find()) {
                matcher1 = pattern1.matcher(matcher.group());
                if (matcher1.find()) {
                    System.out.println(matcher1.group());
                }
            }
        } else {
            System.out.println("No passwords found.");
        }
    }
}