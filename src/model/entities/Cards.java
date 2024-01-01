package model.entities;

public class Cards {
	
	private Integer number;
	private Integer shape;
	private String name;
	private String shapeName;
	
	public Cards(Integer number, Integer shape) {
		this.number = number;
		this.shape = shape;
				
		/*if (this.shape == 1) {
			this.shapeName = "Clubs";
		}
		if (this.shape == 2) {
			this.shapeName = "Hearts";
		}
		if (this.shape == 3) {
			this.shapeName = "Spades";
		}
		if (this.shape == 4) {
			this.shapeName = "Diamonds";
		}
		if (number == 1) {
			this.name = "Ace";
		}
		if (number == 8) {
			this.name = "Jack";
		}
		if (number == 9) {
			this.name = "Queen";
		}
		if (number == 10) {
			this.name = "King";
		}*/


	}
	public Integer getNumber() {
		return number;
	}
	public Integer getShape() {
		return shape;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShapeName() {
		return shapeName;
	}
	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}
	public void cardsNumberIdentifier(){
		
	}
	
	public String cardsShapeIdentifier() {
		if (this.shape == 1) {
			this.shapeName = "Clubs";
		}
		if (this.shape == 2) {
			this.shapeName = "Hearts";
		}
		if (this.shape == 2) {
			this.shapeName = "Spades";
		}
		else {
			this.shapeName = "Diamonds";
		}
		return shapeName;
	}
	@Override
	public String toString() {
		return name + " of " + shapeName;
	}

}
