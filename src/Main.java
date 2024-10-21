import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            // Initial roll
            int die1 = rnd.nextInt(6) + 1; // Die 1 roll (1-6)
            int die2 = rnd.nextInt(6) + 1; // Die 2 roll (1-6)
            int sum = die1 + die2; // Sum of both dice

            System.out.printf("You rolled: %d and %d. Sum: %d%n", die1, die2, sum);

            // Determine the outcome of the initial roll
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out. You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum; // Set the point
                System.out.printf("The point is now: %d%n", point);
                boolean pointReached = false;

                // Subsequent rolls
                while (!pointReached) {
                    die1 = rnd.nextInt(6) + 1; // New roll for die 1
                    die2 = rnd.nextInt(6) + 1; // New roll for die 2
                    sum = die1 + die2; // New sum

                    System.out.printf("You rolled: %d and %d. Sum: %d%n", die1, die2, sum);

                    if (sum == 7) {
                        System.out.println("Got a seven and lost.");
                        pointReached = true;
                    } else if (sum == point) {
                        System.out.println("Made point and won.");
                        pointReached = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
