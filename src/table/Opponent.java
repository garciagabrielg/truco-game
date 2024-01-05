package table;

import java.util.ArrayList;
import java.util.List;

import truco.Cards;

public class Opponent{
	
	private int opponentGamePoints;
	private int opponentRoundPoints;
	private List<Cards> opponentHand = new ArrayList<>();
	private Cards opponentCardOnTheTable;
	
	public Opponent() {
		opponentGamePoints = 0;
		opponentRoundPoints = 0;
	}
	
	public int getOpponentRoundPoints() {
		return opponentRoundPoints;
	}
	
	public List<Cards> getHand(){
	    return opponentHand;

	}

	public Cards getOpponentCardOnTheTable() {
		return opponentCardOnTheTable;
	}
	
	public Cards opponentPlayedCard() {
		return opponentCardOnTheTable = opponentHand.remove((int) (Math.random() * opponentHand.size()));	
	}	

	public int getOpponentGamePoints() {
		return opponentGamePoints;
	}

	public void receiveCard(Cards card) {
		opponentHand.add(card);
	}
	
	public void increaseOpponentGamePoints() {
		opponentGamePoints++;
	}
	public void increaseOpponentRoundPoints() {
		opponentRoundPoints++;
	}
	
	public void resetGamePoints() {
		opponentGamePoints = 0;
	}


}
