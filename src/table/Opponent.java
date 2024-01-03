package table;

import java.util.ArrayList;
import java.util.List;

import truco.Cards;

public class Opponent{
	
	private int opponentGamePoints;
	List<Cards> opponentHand = new ArrayList<>();
	public Cards opponentCarddOnTheTable = new Cards();
	
	
	public void receiveCard(Cards card) {
		opponentHand.add(card);
	}
	
	public List<Cards> getHand(){
		return opponentHand;
	}
	
	public Cards opponentPlayedCard() {
		return opponentCarddOnTheTable = opponentHand.remove((int) (Math.random() * opponentHand.size()));	
	}
	
	public void increaseOpponentGamePoints() {
		opponentGamePoints++;
	}

	public int getOpponentGamePoints() {
		return opponentGamePoints;
	}

	public Cards getOpponentCarddOnTheTable() {
		return opponentCarddOnTheTable;
	}
	
	

}
