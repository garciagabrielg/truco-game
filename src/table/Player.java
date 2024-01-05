package table;

import java.util.ArrayList;
import java.util.List;

import truco.Cards;

public class Player {

	private String name;
	private int playerGamePoints;
	private int playerRoundPoints;
	private List<Cards> playerHand = new ArrayList<>();
	private Cards playerCardOnTheTable;

	public Player() {
		playerGamePoints = 0;
		playerRoundPoints = 0;
	}

	public List<Cards> getHand() {
	    return playerHand;
	}

	public String getName() {
		return name;
	}

	public int getPlayerRoundPoints() {
		return playerRoundPoints;
	}

	public Cards getPlayerCardOnTheTable() {
		return playerCardOnTheTable;
	}

	public int getPlayerGamePoints() {
		return playerGamePoints;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Cards playCard(Cards card) {
		playerHand.remove(card);
		return playerCardOnTheTable = card;		
	}
	
	public void receiveCard(Cards card) {
		playerHand.add(card);
	}
	
	public void increasePoints() {
		playerGamePoints++;
	}
	public void resetGamePoints() {
		playerGamePoints = 0;
	}
	
	public void increaseRoundPoints() {
		playerRoundPoints++;
	}
	
}
