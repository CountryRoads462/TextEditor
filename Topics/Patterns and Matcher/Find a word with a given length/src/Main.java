import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("(\\W|^)[A-Za-z]{" + size + "}(\\W|$)");
        Matcher matcher = pattern.matcher(line);
        System.out.println(matcher.find() ? "YES" : "NO");
    }
}