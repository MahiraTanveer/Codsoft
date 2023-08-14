import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit = 10;
        
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");

        do {
            rounds++;
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsTaken = 0;

            System.out.println("\nRound " + rounds);
            System.out.println("Guess a number between " + lowerBound + " and " + upperBound);

            while (attemptsTaken < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attemptsTaken++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the number " + randomNumber + " in " + attemptsTaken + " attempts.");
                    score++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Sorry, it's too low! Try again.");
                } else {
                    System.out.println("Sorry, it's too high! Try again.");
                }
            }

            if (attemptsTaken == attemptsLimit) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("\nGame over! You played " + rounds + " round(s) and your score is " + score + ".");
                break;
            }

        } while (true);
    }
}
