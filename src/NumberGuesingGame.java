import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesingGame {

    static int wins = 0;
    static int losses = 0;

    public static void main(String[] args) {

        System.out.println("\n\t*** Welcome to the game: Guess the number ***");

        playGame();

    }


    private static void playGame() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100)+1;
        int lives = 10;
        int inputNumber;

        System.out.println("\n> Start the game!");

        while (lives > 0) {
            System.out.println("\n> You have " + lives + " lives.");
            System.out.print("> Enter your number between 1 - 100: ");
            try {
                inputNumber = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("> Invalid input. Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            if (inputNumber > randomNumber) {
                System.out.println("> The number is smaller.");
                lives--;
            } else if (inputNumber < randomNumber) {
                System.out.println("> The number is bigger.");
                lives--;
            } else {
                System.out.println("\n\t*** Congratulations! You guessed the number ***");
                wins++;
                break;
            }
        }

        if (lives == 0) {
            System.out.println("\n\t*** You Lose! You did not guess the number! ***");
            losses++;
        }

        System.out.println("\n> You have " + wins + " wins and " + losses + " losses!");

        playAgain();
    }


    private static void playAgain() {
        Scanner sc = new Scanner(System.in);
        String inputText;

        System.out.print("\n> Do you want to play again? (yes / no): ");
        inputText = sc.nextLine();
        if (inputText.equalsIgnoreCase("yes")) {
            playGame();
        } else if (inputText.equalsIgnoreCase("no")) {
            System.out.println("\n\t*** Thank you for playing! Goodbye! ***");
        } else {
            System.out.println("> You have not entered a valid option!");
            playAgain();
        }
    }
}