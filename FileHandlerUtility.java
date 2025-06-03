import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileHandlerUtility {

    // File path (change it as needed)
    private static final String FILE_PATH = "example.txt";

    public static void main(String[] args) {
        try {
            // 1. WRITE to a file
            writeToFile("Welcome to CodTech Internship!\nCompletion Certificate will be issued on your internship end date.\n");

            // 2. READ from the file
            System.out.println("=== Reading File Contents ===");
            readFromFile();

            // 3. MODIFY the file
            System.out.println("\n=== Modifying File ===");
            modifyFile("CodTech", "CODTECH");

            // 4. READ the modified file
            System.out.println("\n=== Reading Modified File ===");
            readFromFile();

        } catch (IOException e) {
            System.err.println("File operation error: " + e.getMessage());
        }
    }

    // Method to write content to a file
    public static void writeToFile(String content) throws IOException {
        Files.write(Paths.get(FILE_PATH), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("File written successfully.");
    }

    // Method to read content from a file
    public static void readFromFile() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        for (String line : lines) {
            System.out.println(line);
        }
    }

    // Method to modify content in a file
    public static void modifyFile(String target, String replacement) throws IOException {
        Path path = Paths.get(FILE_PATH);
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll(target, replacement);
        Files.write(path, content.getBytes(charset));

        System.out.println("File modified successfully.");
    }
}

Output: File written successfully.
=== Reading File Contents ===
Welcome to CodTech Internship!
Completion Certificate will be issued on your internship end date.

=== Modifying File ===
File modified successfully.

=== Reading Modified File ===
Welcome to CODTECH Internship!
Completion Certificate will be issued on your internship end date.

