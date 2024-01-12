package application;

import java.util.Scanner;

import truco.TrucoException;
import truco.TrucoMatch;

public class Program {

	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);
	    TrucoMatch truco = new TrucoMatch();
	    truco.randomStart();

	    while (!truco.isTheGameFinished()) {
	        try {
	            truco.initialSetup();
	            System.out.println(truco.getTheTurn());
	            System.out.println("P.gp: " + truco.getPlayer().getPlayerGamePoints() + " " + "O.gp: " + truco.getOpponent().getOpponentGamePoints());
	            System.out.println("Player points: " + truco.getRoundsPoints() + " Opponent points: " + truco.getRoundsPoints());
	            System.out.println("Truco points: " + truco.getGamePoints());

	            // Play a turn
	            truco.playTurn();
	            truco.playTurn();


	            // Handle cards on the table after both players have played
	            truco.handleCardsOnTheTable();

	            // Check if the game is finished
	            if (truco.isTheGameFinished()) {
	                System.out.println("Game finished!");
	                break;
	            }

	        } catch (TrucoException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    sc.close();
	}
}
