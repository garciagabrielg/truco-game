package truco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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

	public Cards() {}

	public Cards(Cards removedCard) {
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
		IntStream.rangeClosed(1, 10).forEach(i -> {IntStream.rangeClosed(1, 4)
			.forEach(j -> {deckOfCards.add(new Cards(i, j));});});
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
		for (int i = 0; i<3; i++) {
			Cards removedCard = deckOfCards.remove((int) (Math.random() * deckOfCards.size()));
			hand.add(removedCard);
		}
	}
	public Cards giveTheTurn(Cards turn) {
        return turn = deckOfCards.remove((int) (Math.random() * deckOfCards.size()));

	}
}