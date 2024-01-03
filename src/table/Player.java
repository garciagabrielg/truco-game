package table;

import java.util.ArrayList;
import java.util.List;

import truco.Cards;

public class Player {

	private String name;
	private int playerGamePoints;
	private int playerRoundPoints;
	
	List<Cards> playerHand = new ArrayList<>();
	public Cards playerCardOnTheTable = new Cards();

	public List<Cards> getHand(){
		return playerHand;
	}

	public String getName() {
		return name;
	}

	public int getPlayerRoundPoints() {
		return playerRoundPoints;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerGamePoints() {
		return playerGamePoints;
	}
	
	public Cards playedCard(Cards card) {
		playerHand.remove(card);
		return playerCardOnTheTable = card;		
	}
	
	public void receiveCard(Cards card) {
		playerHand.add(card);
	}
	
	public void increasePoints() {
		playerGamePoints++;
	}
	
	public void increaseRoundPoints() {
		playerRoundPoints++;
	}
	
}
