
package gamecraps;

import java.util.Scanner;
import java.util.Random;

public class GameCraps {

    public static void main(String[] args) throws Exception {

        double numberOfGames, numberWins, numberLoses, gameResluts,
                probabilityWinning;

        Scanner sc = new Scanner(System.in);

        promptUser();
        
       

        numberOfGames = sc.nextDouble();

        while (numberOfGames > 0) {
           
            numberWins = 0;
            numberLoses = 0;
            
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < numberOfGames; i++) {

                gameResluts = craps();

                if (gameResluts == 1) {
                    numberWins++;
                } else if (gameResluts == 2) {
                    numberLoses++;
                }

            }
            long endTime = System.currentTimeMillis();

            probabilityWinning = numberWins / numberOfGames;

            System.out.printf("numberWins=%.0f%nnumberLoses=%.0f%n", numberWins,
                    numberLoses);
             
            System.out.println("Total excution time:" + (endTime - startTime));

            System.out.printf("ProbabilityWinning = %.4f%n%n",
                    probabilityWinning);
            

            System.out.print("Please enter the number of games you want to "
                    + "play: ");
            

            numberOfGames = sc.nextInt();
        }

    }
// End of Main

    public static void promptUser() {

        System.out.println("This program estimates the probability winning the "
                + "game of Craps using the Monte Carlo method.");

        System.out.print(" Please enter the number of games you want to play: "
                + "");

    }
// This method is used to play the game of Craps.

    public static int craps() {

        Random rand = new Random();

        int die1 = rand.nextInt(6) + 1;
        int die2 = rand.nextInt(6) + 1;

        int sum1, sum2, gameResults;

        sum1 = die1 + die2;

        if (sum1 == 7 || sum1 == 11) {
            gameResults = 1;

        } else if (sum1 == 2 || sum1 == 3 || sum1 == 12) {

            gameResults = 2;

        } else {
            gameResults = 0;

            while (gameResults == 0) {

                die1 = rand.nextInt(6) + 1;
                die2 = rand.nextInt(6) + 1;

                sum2 = die1 + die2;

                if (sum2 == sum1) {
                    gameResults = 1;

                } else if (sum2 == 7) {
                    gameResults = 2;

                } else {
                    gameResults = 0;
                }
            }

        }

        return gameResults;
    }
}
//End of program.
