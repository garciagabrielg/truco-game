package truco;

import table.Opponent;
import table.Player;

public class TrucoMatch {
	
	private int gamePoints = 0;
	private int roundsPoints = 0;
	private int gameTurn = 0;
	private int roundTurn = 0;
	
	private Cards theTurn;
		
	private Player player;
	private Opponent opponent;
	
	
	public TrucoMatch(Player player, Opponent opponent) {
		this.player = player;
		this.opponent = opponent;
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


	public void upateGamePoints() {
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

}
