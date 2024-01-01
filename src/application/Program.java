package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.Cards;

public class Program {

	public static void main(String[] args) {

		List<Cards> DeckCards = new ArrayList<>();

		for (int i = 1; i<=10;i++) {
			for (int j = 1; j<=4;j++) {
				DeckCards.add(new Cards (i, j));
			}
		}

		DeckCards.forEach(System.out::println);
	}

}
