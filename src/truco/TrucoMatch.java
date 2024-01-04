package truco;

import table.Opponent;
import table.Player;

public class TrucoMatch {
    private int gamePoints = 0;
    private int roundsPoints = 0;
    private int gameTurn = 0;
    private int roundTurn = 0;
    private Cards cards;
    private Cards manille;
    private Cards theTurn;
    private Player player;
    private Opponent opponent;

    public TrucoMatch() {
    	player = new Player();
    	opponent = new Opponent();
    	cards = new Cards();
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
    
    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
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
    
    public void theTurnCard() {
    	theTurn = cards.giveTheTurn();
    }
    
    //check if theManille card is one faceValue above theTurn
    public Cards isManille() {
        manille = new Cards();   
        if (theTurn == null) {
        	throw new TrucoException("Sorry, the Turn is null ");
        }
 
        if (theTurn.getFaceValue() == 10) {
            manille = new Cards(1, theTurn.getShape());
        }
        if (player.getPlayerCardOnTheTable() != null && player.getPlayerCardOnTheTable().getFaceValue() == theTurn.getFaceValue() + 1) {
            return manille = player.getPlayerCardOnTheTable();
        }
        if (opponent.getOpponentCardOnTheTable() != null && opponent.getOpponentCardOnTheTable().getFaceValue() == theTurn.getFaceValue() + 1) {
            return manille = opponent.getOpponentCardOnTheTable();
        }
        if (player.getPlayerCardOnTheTable() != null && opponent.getOpponentCardOnTheTable() != null &&
            player.getPlayerCardOnTheTable().getFaceValue() == opponent.getOpponentCardOnTheTable().getFaceValue()){
            if (player.getPlayerCardOnTheTable().getShape() < opponent.getOpponentCardOnTheTable().getShape()){
                return manille = player.getPlayerCardOnTheTable();
            } else if (opponent.getOpponentCardOnTheTable().getShape() < player.getPlayerCardOnTheTable().getShape()) {
                return manille = opponent.getOpponentCardOnTheTable();
            }
        }
        return manille;
    }

    public void updateGamePoints() {
        if (player.getPlayerGamePoints() == 2 || opponent.getOpponentGamePoints() == 2) {
            gamePoints = 0;
            gameTurn = 0;
            roundsPoints++;
            roundTurn++;
        }
        Cards manilhaCard = isManille();
        //theManille is the commanding card. if is on the table on either side of the parties, and one of the parties wins, it should update the game points
        if (player.getPlayerCardOnTheTable() == manilhaCard) {
            player.increasePoints();
            gamePoints++;
            gameTurn++;

        } else if (opponent.getOpponentCardOnTheTable() == manilhaCard) {
            opponent.increaseOpponentGamePoints();
            gamePoints++;
            gameTurn++;
        }

        if (player.getPlayerCardOnTheTable().getFaceValue() > opponent.getOpponentCardOnTheTable().getFaceValue()
                || (player.getPlayerCardOnTheTable().getFaceValue() == opponent.getOpponentCardOnTheTable().getFaceValue()
                        && player.getPlayerCardOnTheTable().getShape() < opponent.getOpponentCardOnTheTable().getShape())) {
            player.increasePoints();
            gamePoints++;
            gameTurn++;

        } else {
            opponent.increaseOpponentGamePoints();
            gamePoints++;
            gameTurn++;
        }  
    }

    public boolean isTheGameFinished() {
        if (player.getPlayerRoundPoints() == 15 || opponent.getOpponentRoundPoints() == 15) {
            return true;
        }
        return false;
    }
    
    public void initialSetup() {
    	if (!cards.getDeckOfCards().isEmpty()) {
    		cards.getDeckOfCards().clear();
    	}
        cards.addToDeck();
        theTurnCard();
        if(player.getPlayerGamePoints() > 0 || opponent.getOpponentGamePoints() > 0) {
    		if (!player.getHand().isEmpty() && !opponent.getHand().isEmpty()) {
    			player.getHand().clear();
    			opponent.getHand().clear();
    		}
    	}
        cards.giveCards(player.getHand());
        cards.giveCards(opponent.getHand());
    }
}
