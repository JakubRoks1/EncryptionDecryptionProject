import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();

        String text = scanner.nextLine();

        int key = scanner.nextInt();

        if ("enc".equals(operation)) {
            String encryptedText = encryption(text, key);
            System.out.println(encryptedText);
        } else if ("dec".equals(operation)) {
            String decryptedText = decryption(text, key);
            System.out.println(decryptedText);
        } else {
            System.out.println("Unknown operation. Please enter 'enc' or 'dec'.");
        }

        scanner.close();
    }

    private static String encryption(String input, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            result.append(encryptChar(c, key));
        }

        return result.toString();
    }

    private static String decryption(String input, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            result.append(decryptChar(c, key));
        }

        return result.toString();
    }

    private static char encryptChar(char c, int key) {
        return (char) (c + key);
    }

    private static char decryptChar(char c, int key) {
        return (char) (c - key);
    }
}