import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class FindTheKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("the\\s+key\\s+is\\s+[a-z0-9?!#]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            Pattern pattern1 = Pattern.compile("(\\s([0-9]|[^eiuoa!#?])+$)|(\\s[?!#eiuoa]+$)", Pattern.CASE_INSENSITIVE);
            Matcher matcher1 = pattern1.matcher(matcher.group());
            if (matcher1.find()) {
                System.out.println(matcher1.group().substring(1));
            }
        }
    }
}