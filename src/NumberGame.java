import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int totalAllowedGuesses = 10;
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("You need to guess a number between 1 - 100. You get only "+ totalAllowedGuesses +" guesses");
        Random random = new Random();
        int originalNumber = random.nextInt(100);

        int i;
        for (i=0; i< totalAllowedGuesses; i++) {
            int guessedNumber = scanner.nextInt();
            if (guessedNumber < 1 || guessedNumber > 100) {
                System.out.println("Invalid Input: Please enter a number between 1 - 100");
                i--;
                continue;
            }


            if (guessedNumber == originalNumber) {
                System.out.println("Congratulations Correct Guess!!! Your score is " + (totalAllowedGuesses - i - 1) * 99);
                break;
            } else if (guessedNumber < originalNumber) {
                System.out.println("The correct answer is greater than " + guessedNumber);
            } else if (guessedNumber > originalNumber) {
                System.out.println("The correct answer is smaller than " + guessedNumber);
            }
            System.out.println("Please enter your next guess! you've "+ (totalAllowedGuesses - i - 1) +" guesses left!");
        }

        if(i == totalAllowedGuesses)
            System.out.println("Correct Answer was " + originalNumber + ", Better Luck next time.");


    }
}
