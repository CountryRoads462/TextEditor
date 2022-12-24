import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();
        Pattern pattern1 = Pattern.compile("(19|20)\\d{2}[- /.](0[1-9]|1[0-2])[- /.]([0][1-9]|[1-2][0-9]|[3][0-1])");
        Pattern pattern2 = Pattern.compile("([0][1-9]|[1-2][0-9]|[3][0-1])[- /.](0[1-9]|1[0-2])[- /.](19|20)\\d{2}");
        Matcher matcher1 = pattern1.matcher(date);
        Matcher matcher2 = pattern2.matcher(date);

        if (matcher1.matches() || matcher2.matches()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}