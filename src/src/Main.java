import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String inputFile = "";
        String outputFile = "";
        String algorithm = "shift"; // Default algorithm is shift

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
                case "-alg":
                    algorithm = args[i + 1].toLowerCase();
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

        switch (algorithm) {
            case "shift":
                if ("enc".equals(mode)) {
                    result = shiftAlgorithm(data, key);
                } else if ("dec".equals(mode)) {
                    result = shiftAlgorithm(data, -key);
                }
                break;
            case "unicode":
                if ("enc".equals(mode)) {
                    result = unicodeAlgorithm(data, key);
                } else if ("dec".equals(mode)) {
                    result = unicodeAlgorithm(data, -key);
                }
                break;
            default:
                System.out.println("Error: Invalid algorithm.");
                System.exit(1);
        }

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

    private static String shiftAlgorithm(String input, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            result.append(encryptChar(c, key));
        }

        return result.toString();
    }

    private static String unicodeAlgorithm(String input, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            result.append((char) (c + key));
        }

        return result.toString();
    }

    private static char encryptChar(char c, int key) {
        if (Character.isLetter(c)) {
            int base = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) (((c - base + key) % 26 + 26) % 26 + base);
        }
        return c;
    }
}
