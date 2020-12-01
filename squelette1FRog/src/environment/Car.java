package environment;

import java.awt.Color;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public Car(Game game, Case leftPosition, boolean leftToRight ) {
		this.game = game;
		this.length = game.randomGen.nextInt(3);
		this.leftPosition = new Case(leftPosition.absc, leftPosition.ord);
		this.leftToRight = leftToRight;


	}

	//TODO : ajout de methodes

	public void move() {
		if (leftToRight) {
			this.leftPosition = new Case(leftPosition.absc + 1, leftPosition.ord);
		} else {
			this.leftPosition = new Case(leftPosition.absc - 1, leftPosition.ord);
		}
	}



	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	 public void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight) {
				color = colorLtR;
			}
			game.getGraphic().add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

	public boolean isSafe (Case c){

	 		if (c.absc == leftPosition.absc && c.absc < leftPosition.absc + this.length){
	 			return false;
			}else{
	 			return true;
			}
		}


}

