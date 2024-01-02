package table;

import java.util.ArrayList;
import java.util.List;

import truco.Cards;

public class Player {

	private String name;
	
	List<Cards> playerHand = new ArrayList<>();
	
	public void receiveCard(Cards card) {
		playerHand.add(card);
	}
	
	public List<Cards> getHand(){
		return playerHand;
	}
}
