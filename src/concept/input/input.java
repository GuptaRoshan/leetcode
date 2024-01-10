package concept.input;

import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a);
        int b = scanner.nextInt();
        System.out.println(b);
        String line = scanner.nextLine();
        System.out.println(line);
    }
}
