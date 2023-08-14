import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Word Counting Program");
        System.out.println("1. Enter 1 to input text manually");
        System.out.println("2. Enter 2 to input text from a file");

        int choice = sc.nextInt();
	sc.nextLine();
        if (choice==1) {
            System.out.println("Enter your text:");
            String input = sc.nextLine();
            int wordCount = countWords(input);
            System.out.println("Total words: " + wordCount);
        } else if (choice==2) {
            System.out.print("Enter the file path: ");
            String filePath = sc.nextLine();
            try {
                String fileContent = readFile(filePath);
                int wordCount = countWords(fileContent);
                System.out.println("Total words in the file: " + wordCount);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Exiting...");
        }
    }

    public static int countWords(String text) {
        String[] words = text.split(" ");
        return words.length;
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
