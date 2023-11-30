
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String inputFile = "";
        String outputFile = "";

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    inputFile = args[i + 1];
                    break;
                case "-out":
                    outputFile = args[i + 1];
                    break;
            }
        }

        if (!inputFile.isEmpty()) {
            try {
                data = new String(Files.readAllBytes(Paths.get(inputFile)), StandardCharsets.UTF_8);
            } catch (Exception e) {
                System.out.println("Error: Unable to read input file.");
                System.exit(1);
            }
        }

        String result = "";

        if ("enc".equals(mode)) {
            result = encryption(data, key);
        } else if ("dec".equals(mode)) {
            result = decryption(data, key);
        }

        System.out.println(result);

        if (!outputFile.isEmpty()) {
            try {
                Files.write(Paths.get(outputFile), result.getBytes(StandardCharsets.UTF_8));
            } catch (Exception e) {
                System.out.println("Error: Unable to write to output file.");
                System.exit(1);
            }
        } else {
            System.out.println(result);
        }
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
