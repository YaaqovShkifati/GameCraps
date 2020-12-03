/**
 * @auther Yaaqov Shkifati
 * @since 03/5/2020
 * @verison 1.0 Description: In the program will be using a Monte Carlo
 * simulations to estimate the probability of winning a game of Craps. Monte
 * Carlo is a mechanism that can not easily be predicted due to the presence of
 * random variables, Monte Carlo simulations are used to model the probability
 * of various outcomes. It is a technique used in the prediction and forecasting
 * models to consider the effects of risk and uncertainty. However, computers
 * are programed to eliminate randomness results and relying on algorithms to
 * compile. This means that they can't really generate a truly random number
 * because the computer is following the same algorithm to generate them. What
 * will do in this program, seed a pseudo random number from the time in seconds
 * before midnight for the both dices to generate a random number. The sum of
 * both dices equals 7 or 11 means you won which would represent(1) and sum 2,3,
 * and 12 means you lose represents(2) other results need to toss again
 * representing(0). Giving the game won over how many games played would give us
 * the probability of wining a game of craps. The more games we play the more
 * accurate results will get it.
 *
 * The way will write this program is that will seed our random number generator
 * beginning and at the end. Then create a while loop with a condition that
 * number of throws is greater than zero. Within the loop will create a for loop
 * that will execute the number of given throws. Within the for loop will call
 * the method called carps that will play the game of craps and return game
 * results. If the carps results return a 0 then will have to toss again so,
 * will create another while loop that will call the method of craps again until
 * the results return 1(win) or 2(lose) also will have a variable name
 * playedGames that will add one every time we repeated the game. If the results
 * return 1 then will have a variable name numberWins that will add 1. If
 * results return 2 then will have a variable name numberLoses that will add 1.
 * For each time we win or lose will add 1 to the variable playedGame to keep
 * track of all the games that was played. To get the probability of winning
 * will divide numberWins/playedGame. Then will enter a zero to exit the loop.
 *
 * This program thought me; statistics, application of integration, generating a
 * pseudo random number, and the probability of winning a game of craps at a
 * casino. Even though this program was short and was easy to write it required
 * a lot of research to comprehending pseudo random numbers and how they work. I
 * realized that Monte Carlo method is a method of solving problems using
 * statistics. Given the probability that a certain event will occur in certain
 * conditions, a computer can be used to generate those conditions repeatedly.
 * in addition, during my research it help understand better the Copenhagen
 * doctrine by Bohr and Heisenberg which states at the most fundamental level,
 * the behavior of a physical system cannot be determined. That means that every
 * event is not caused by pervious event its at random.
 *
 */
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
