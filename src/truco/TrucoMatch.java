package truco;

import java.util.Random;
import java.util.Scanner;

import table.Opponent;
import table.Player;

public class TrucoMatch {
	private int gamePoints = 0;
	private int roundsPoints = 0;
	private int roundTurn = 0;
	private Cards cards;
	private Cards manille;
	private Cards theTurn;
	private Player player;
	private Opponent opponent;
	private boolean playerWonLastRound = false;
	private boolean opponentTurn = false;
	boolean opponentHasPlayed = false;
	boolean playerHasPlayed = false;

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
		if (theTurn == null) {
			theTurn = cards.giveTheTurn();
		}
	}

	// check if theManille card is one faceValue above theTurn
	public Cards isManille() {
		manille = new Cards();
		if (theTurn == null) {
			throw new TrucoException("Sorry, the Turn is null ");
		}
		int expectedFaceValue = theTurn.getFaceValue() + 1;
		if (theTurn.getFaceValue() == 10) {
			if (isManilleCard(player.getPlayerCardOnTheTable())) {
				return manille = player.getPlayerCardOnTheTable();
			}
			if (isManilleCard(opponent.getOpponentCardOnTheTable())) {
				return manille = opponent.getOpponentCardOnTheTable();
			}
		}
		if (isManilleCard(player.getPlayerCardOnTheTable(), expectedFaceValue)) {
			return manille = player.getPlayerCardOnTheTable();
		}

		if (isManilleCard(opponent.getOpponentCardOnTheTable(), expectedFaceValue)) {
			return manille = opponent.getOpponentCardOnTheTable();
		}

		if (isSameFaceValue(player.getPlayerCardOnTheTable(), opponent.getOpponentCardOnTheTable())) {
			if (player.getPlayerCardOnTheTable().getShape() < opponent.getOpponentCardOnTheTable().getShape()) {
				return manille = player.getPlayerCardOnTheTable();
			} else if (opponent.getOpponentCardOnTheTable().getShape() < player.getPlayerCardOnTheTable().getShape()) {
				return manille = opponent.getOpponentCardOnTheTable();
			}
		}
		return null;
	}

	private boolean isManilleCard(Cards card) {
		return card != null && card.getFaceValue() == 1;
	}

	private boolean isManilleCard(Cards card, int expectedFaceValue) {
		return card != null && card.getFaceValue() == expectedFaceValue;
	}

	private boolean isSameFaceValue(Cards card1, Cards card2) {
		return card1 != null && card2 != null && card1.getFaceValue() == card2.getFaceValue();
	}

	public void handleCardsOnTheTable() {
		Cards manille = isManille();
		if (manille != null) {
			handleManilleScenario(manille);
		} else {
			handleNormalScenario();
		}
		if (player.getPlayerCardOnTheTable() == null || opponent.getOpponentCardOnTheTable() == null) {
			throw new TrucoException("Error ");
		}
	}

	private void handleManilleScenario(Cards manilleCard) {
		if (player.getPlayerCardOnTheTable() == manilleCard
				&& getOpponent().getOpponentCardOnTheTable() == manilleCard) {
			handleTieBreakerScenario();
		} else if (player.getPlayerCardOnTheTable() == manilleCard) {
			player.increasePoints();
			gamePoints++;
			playerWonLastRound = true;

		} else {
			opponent.increaseOpponentGamePoints();
			gamePoints++;
			playerWonLastRound = false;

		}
	}

	private void handleTieBreakerScenario() {
		if (player.getPlayerCardOnTheTable().getShape() < opponent.getOpponentCardOnTheTable().getShape()) {
			player.increasePoints();
			gamePoints++;
			playerWonLastRound = true;

		} else {
			opponent.increaseOpponentGamePoints();
			gamePoints++;
			playerWonLastRound = false;

		}
	}

	private void handleNormalScenario() {
		if (player.getPlayerCardOnTheTable().getFaceValue() == opponent.getOpponentCardOnTheTable().getFaceValue()) {
			handleTieBreakerScenario();
		} else if (player.getPlayerCardOnTheTable().getFaceValue() > opponent.getOpponentCardOnTheTable()
				.getFaceValue()) {
			player.increasePoints();
			gamePoints++;
			playerWonLastRound = true;

		} else {
			opponent.increaseOpponentGamePoints();
			gamePoints++;
			playerWonLastRound = false;

		}
	}
// melhorar isso aqui
	public void updateRoundPoints() {
		if (player.getPlayerGamePoints() > 1) {
			player.increaseRoundPoints();
			playerWonLastRound = true;
		} else if (opponent.getOpponentGamePoints() > 1) {
			opponent.increaseOpponentRoundPoints();
			playerWonLastRound = false;
		}
	}

	private void resetGame() {
		gamePoints = 0;
		player.resetGamePoints();
		opponent.resetGamePoints();
		roundsPoints++;
		roundTurn++;
		cards.getDeckOfCards().clear();
		theTurn = null;
		if (!player.getHand().isEmpty() && !opponent.getHand().isEmpty()) {
			player.getHand().clear();
			opponent.getHand().clear();
		}
	}

	public boolean isTheGameFinished() {
		if (player.getPlayerRoundPoints() == 15 || opponent.getOpponentRoundPoints() == 15) {
			return true;
		}
		return false;
	}

	public void initialSetup() {
		if (player.getPlayerGamePoints() > 1 || opponent.getOpponentGamePoints() > 1) {
			resetGame();
			updateRoundPoints();
		}
		if (cards.getDeckOfCards().isEmpty()) {
			cards.addToDeck();
			theTurnCard();
			cards.giveCards(player.getHand());
			cards.giveCards(opponent.getHand());
		}
	}

	public boolean whoWonLastRound() {
		if (playerWonLastRound) {
			return opponentTurn = false;
		} else {
			return opponentTurn = true;
		}
	}

	public void randomStart() {
		Random random = new Random();
		opponentTurn = random.nextBoolean();
		System.out.println(opponentTurn ? "Opponent goes first." : "You go first.");
	}

	public void playTurn() {

		if (gamePoints >= 1) {
			whoWonLastRound();

		}
		if (playerHasPlayed && !opponentHasPlayed) {
			opponentTurn = true;
		} else if (!playerHasPlayed && opponentHasPlayed) {
			opponentTurn = false;
		}
		if (!opponentTurn) {
			play();
			playerHasPlayed = true;
		} else {
			opponentPlay();
			opponentHasPlayed = true;
		}
		if (playerHasPlayed == true && opponentHasPlayed == true) {
			playerHasPlayed = false;
			opponentHasPlayed = false;
		}
		//opponentTurn = !opponentTurn;
	}

	public void play() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Player's turn.");
		System.out.println("Player hand: " + player.getHand());
		System.out.println("Choose a card index to play:");
		int cardIndex = sc.nextInt();
		Cards playedCard = player.playCard(player.getHand().get(cardIndex));
		System.out.println("Player played: " + playedCard);
		System.out.println();
	}

	public void opponentPlay() {
		System.out.println("Opponent's turn.");
		Cards opponentPlayedCard = opponent.opponentPlayedCard();
		System.out.println("Opponent played: " + opponentPlayedCard);
		System.out.println();
	}
}
