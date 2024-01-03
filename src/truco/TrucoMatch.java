package truco;

import java.util.ArrayList;
import java.util.List;

import table.Opponent;
import table.Player;

public class TrucoMatch {
	
	private int gamePoints = 0;
	private int roundsPoints = 0;
	private int gameTurn = 0;
	private int roundTurn = 0;
	List<Cards> deck = new ArrayList<>();
	private Cards cards = new Cards();
	public Cards theTurn;
	private Cards manilha;
		
	private Player player;
	private Opponent opponent;
	
	
	public TrucoMatch() {
		player = new Player();
		opponent = new Opponent();
	}


	public void setTheTurn(Cards theTurn) {
		this.theTurn = theTurn;
	}


	public int getGamePoints() {
		return gamePoints;
	}


	public int getRoundsPoints() {
		return roundsPoints;
	}


	public int getGameTurn() {
		return gameTurn;
	}


	public int getRoundTurn() {
		return roundTurn;
	}


	public Cards getTheTurn() {
		return theTurn;
	}


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Opponent getOpponent() {
		return opponent;
	}


	public void setOpponent(Opponent opponent) {
		this.opponent = opponent;
	}
	
	
	public Cards isManilha() {
		if (theTurn.getFaceValue() == 10) {
			manilha.setFaceValue(1);
		}
		if (player.playerCardOnTheTable.getFaceValue() == theTurn.getFaceValue()+1) {
			return manilha = player.playerCardOnTheTable;	
		}
		if (opponent.opponentCarddOnTheTable.getFaceValue() == theTurn.getFaceValue()+1) {
			return manilha = opponent.opponentCarddOnTheTable;
		}
		if (player.playerCardOnTheTable.getFaceValue() == opponent.opponentCarddOnTheTable.getShape()) {
			if (player.playerCardOnTheTable.getShape() < opponent.opponentCarddOnTheTable.getShape())
				return manilha = player.playerCardOnTheTable;
			else if (opponent.opponentCarddOnTheTable.getShape() < player.playerCardOnTheTable.getShape()) {
				return manilha = opponent.opponentCarddOnTheTable;
			}
		}
		return manilha;
	}


	public void upateGamePoints() {
		if (player.getPlayerGamePoints() == 2 || opponent.getOpponentGamePoints() == 2) {
			gamePoints = 0;
			gameTurn = 0;
			roundsPoints++;
			roundTurn ++;
		}
		if (player.playerCardOnTheTable == isManilha()) {
			player.increasePoints();
		}
		else if (opponent.opponentCarddOnTheTable == isManilha()) {
			opponent.increaseOpponentGamePoints();
		}
		
		if(player.playerCardOnTheTable.getFaceValue() > opponent.getOpponentCarddOnTheTable().getFaceValue() 
				|| (player.playerCardOnTheTable.getFaceValue() == opponent.getOpponentCarddOnTheTable().getFaceValue() 
						&& player.playerCardOnTheTable.getShape() < opponent.getOpponentCarddOnTheTable().getShape() )) {		
			player.increasePoints();;
		}
		else {
			opponent.increaseOpponentGamePoints();
		}
		gamePoints ++;
		gameTurn ++;
	}
	
	public boolean isTheGameFinished() {
		if (player.getPlayerRoundPoints() == 15 || opponent.getOpponentRoundPoints() == 15) {
			return true;
		}
		return false;
	}


	public Cards getCards() {
		return cards;
	}


	public void setCards(Cards cards) {
		this.cards = cards;
	}

}
