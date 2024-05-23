import java.util.Scanner;

public final class InputReader {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INVALID_INPUT_MSG = "Entrada inválida!";

    public static String readString(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();

        while (input.isEmpty()) {
            System.out.println(INVALID_INPUT_MSG);
            System.out.println(prompt);

            input = scanner.nextLine().trim();
        }

        return input;
    }

    public static int readInt(String prompt) {
        System.out.println(prompt);

        while (!scanner.hasNextInt()) {
            System.out.println(INVALID_INPUT_MSG);
            scanner.next();
        }

        int input = scanner.nextInt();
        scanner.nextLine();

        return input;
    }

    public static double readDouble(String prompt) {
        System.out.println(prompt);

        while (!scanner.hasNextDouble()) {
            System.out.println(INVALID_INPUT_MSG);
            scanner.next();
        }

        double input = scanner.nextDouble();
        scanner.nextLine();

        return input;
    }
}
