package truco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cards {
	
	private Integer faceValue;
	private Integer shape;
	List<Cards> deckOfCards = new ArrayList<>();
	
	public Cards(Integer faceValue, int shape) {
		if (faceValue < 1 || faceValue > 10 || shape < 1 || shape > 4 ) {
			throw new IllegalArgumentException("Invalid face value or shape for a standard deck card: " + faceValue + ", " + shape);
		}
		this.faceValue = faceValue;
		this.shape = shape;
	}

	public Cards() {
		// TODO Auto-generated constructor stub
	}

	public Integer getFaceValue() {
		return faceValue;
	}

	public Integer getShape() {
		return shape;
	}
	
	public List<Cards> getDeckOfCards() {
		return deckOfCards;
	}

	public void addToDeck () {
		for (int i = 1; i<=10;i++) {
			for (int j = 1; j<=4;j++) {
				deckOfCards.add(new Cards(i, j));
				}
			}
	}
	
	@Override
	public String toString() {
		String faceName = getFaceName();
		String shapeName = getShapeName();
		return faceName + " of " + shapeName;
	}
	
	private String getFaceName() {
		switch(faceValue) {
		case 1: return "Ace";
		case 8: return "Jack";
		case 9: return "Queen";
		case 10: return "King";
		default: return String.valueOf(faceValue);
		}
	}
	
	private String getShapeName() {
		switch(shape) {
		case 1: return "Clubs";
		case 2: return "Hearts";
		case 3: return "Spades";
		case 4: return "Diamonds";
		default: return "Unknown Shape";
		}
	}
	
	public void shuffleCards() {
			Collections.shuffle(deckOfCards);
		}
	
	public void giveCards(List<Cards> hand) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(deckOfCards.size() - 1);
	
		for (int i = 0; i<3; i++) {
			Cards removedCard = deckOfCards.remove(randomIndex);
			hand.add(removedCard);
		}

	}
}
