import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String yearsExp = scanner.nextLine();
        String preference = scanner.nextLine();
        System.out.println("The form for " + name + " is completed. We will contact you if we need a chef who cooks " + preference + " dishes and has " + yearsExp + " years of experience.");
    }
}