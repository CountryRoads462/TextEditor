import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        List<String> stringList = new ArrayList<>(Arrays.asList(array));
        ListIterator<String> stringListIterator = stringList.listIterator();
        while (stringListIterator.hasNext()) {
            String currentString = stringListIterator.next();
            if (!currentString.startsWith("J")) {
                stringListIterator.remove();
            }
        }
        while (stringListIterator.hasPrevious()) {
            String elem = stringListIterator.previous();
            elem = elem.substring(1);
            System.out.println(elem);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}