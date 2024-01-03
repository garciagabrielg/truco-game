package table;

import java.util.ArrayList;
import java.util.List;

import truco.Cards;

public class Player {

	private String name;
	private int playerGamePoints = 0;
	
	List<Cards> playerHand = new ArrayList<>();
	public Cards playerCardOnTheTable = new Cards();
	
	public void receiveCard(Cards card) {
		playerHand.add(card);
	}
	
	public List<Cards> getHand(){
		return playerHand;
	}
	
	public Cards playedCard(Cards card) {
		playerHand.remove(card);
		return playerCardOnTheTable = card;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerGamePoints() {
		return playerGamePoints;
	}
	
	public void increasePoints() {
		playerGamePoints++;
	}
}
