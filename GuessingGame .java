import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;

        while (playAgain) {
            int rangeStart = 1;
            int rangeEnd = 100;
            int maxAttempts = 10;
            int numberToGuess = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I have picked a number between " + rangeStart + " and " + rangeEnd + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts >= maxAttempts && !hasGuessedCorrectly) {
                    System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
