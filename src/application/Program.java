package application;

import java.util.Scanner;

import truco.Cards;
import truco.TrucoException;
import truco.TrucoMatch;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		Cards cards = new Cards();
		TrucoMatch truco = new TrucoMatch();

		while(!truco.isTheGameFinished()) {
			try {
			truco.initialSetup();
			truco.theTurnCard();
			for (Cards x : cards.getDeckOfCards())
				System.out.println(x);
			
			System.out.println();
			System.out.println(truco.getTheTurn());
			
			
			System.out.println();
			
			for (Cards x : truco.getPlayer().getHand()) {
				System.out.println(x);
				
			}
			System.out.println();
			System.out.println("play a card ");
			Cards playerCard = truco.getPlayer().playCard(truco.getPlayer().getHand().get(sc.nextInt()));
			System.out.println();
			
			
			
			System.out.println("Player card: " + truco.getPlayer().playCard(playerCard));
			System.out.println("Opponent card: " + truco.getOpponent().opponentPlayedCard());
			truco.updateGamePoints();
			System.out.println(truco.getGamePoints());
			
			System.out.println("Player points: " + truco.getPlayer().getPlayerGamePoints() + " " + truco.getPlayer().getPlayerRoundPoints());
			System.out.println("Opponent points: " + truco.getOpponent().getOpponentGamePoints() + " " + truco.getOpponent().getOpponentRoundPoints());
				
			
			System.out.println(truco.getCards().getDeckOfCards().size());
			System.out.println();
			}
			catch(TrucoException e) {
				System.out.println(e.getMessage());
			}

		}
			
		
		sc.close();
	}

}
