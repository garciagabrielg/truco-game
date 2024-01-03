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
		Player player = new Player();
		Opponent opponent = new Opponent();
		TrucoMatch truco = new TrucoMatch(player, opponent);

		cards.addToDeck();
		cards.shuffleCards();

		System.out.println(cards.getDeckOfCards().size());
		
		cards.giveTheTurn(cards);
		cards.giveCards(player.getHand());
		cards.giveCards(opponent.getHand());
		
		System.out.println(cards.giveTheTurn(cards));
		System.out.println();
		
		for (Cards x : player.getHand()) {
			System.out.println(x);
			
		}
		System.out.println();
		System.out.println("play a card ");
		Cards playerCard = player.playedCard(player.getHand().get(sc.nextInt()));
		Cards oppCard = opponent.opponentPlayedCard();
		
		
		
		System.out.println(player.playedCard(playerCard));
		System.out.println(opponent.opponentPlayedCard());
		
		truco.upateGamePoints();
		
		System.out.println("Player points: " + player.getPlayerGamePoints());
		System.out.println("Opponent points: " + opponent.getOpponentGamePoints());
			
		
		System.out.println(cards.getDeckOfCards().size());
		
		sc.close();
	}

}
