package application;

import java.util.Scanner;

import truco.Cards;
import truco.TrucoException;
import truco.TrucoMatch;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		TrucoMatch truco = new TrucoMatch();

        while (!truco.isTheGameFinished()) {
            try {
                truco.initialSetup();
                System.out.println(truco.getTheTurn());
                System.out.println(truco.getPlayer().getPlayerGamePoints() + " " + truco.getOpponent().getOpponentGamePoints());

                // Play a turn
                truco.playTurn();

                // Check if the game is finished
                if (truco.isTheGameFinished()) {
                    System.out.println("Game finished!");
                    break;
                }

                // You can add more logic or user interactions here if needed
            } catch (TrucoException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
