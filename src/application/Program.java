package application;

import table.Opponent;
import table.Player;
import truco.Cards;

public class Program {

	public static void main(String[] args) {
		
		Cards cards = new Cards();
		Player player = new Player();
		Player opponent = new Opponent();

		cards.addToDeck();
		cards.shuffleCards();

		System.out.println(cards.getDeckOfCards().size());
		
		cards.giveCards(player.getHand());
		cards.giveCards(opponent.getHand());
		
		for (Cards x : player.getHand()) {
			System.out.println(x);
		}
		for (Cards x : opponent.getHand()) {
			System.out.println(x);
		}
		
		System.out.println(cards.getDeckOfCards().size());
	}

}
