package application;

import java.util.Scanner;

import table.Opponent;
import table.Player;
import truco.Cards;
import truco.TrucoMatch;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Cards cards = new Cards();
		TrucoMatch truco = new TrucoMatch();

		while(!truco.isTheGameFinished()) {
			
			cards.initialSetup();
			cards.giveTheTurn();
			
			System.out.println(cards.getDeckOfCards().size());
			
			
			System.out.println();
			
			for (Cards x : truco.getPlayer().getHand()) {
				System.out.println(x);
				
			}
			System.out.println();
			System.out.println("play a card ");
			/*Cards playerCard = player.playedCard(player.getHand().get(sc.nextInt()));
			Cards oppCard = opponent.opponentPlayedCard();
			
			
			
			System.out.println(player.playedCard(playerCard));
			System.out.println(opponent.opponentPlayedCard());*/
			
			truco.upateGamePoints();
			
			System.out.println("Player points: " + truco.getPlayer().getPlayerGamePoints());
			System.out.println("Opponent points: " + truco.getOpponent().getOpponentGamePoints());
				
			
			System.out.println(cards.getDeckOfCards().size());

		}
			
		
		System.out.println(cards.getDeckOfCards().size());
		
		sc.close();
	}

}
