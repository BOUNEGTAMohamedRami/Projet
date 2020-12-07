package environment;

import gameCommons.Game;
import gameCommons.GameInf;

import graphicalElements.Element;
import util.Case;

import java.awt.*;

public class CarInf {
	private GameInf game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public CarInf(GameInf game, Case leftPosition, boolean leftToRight ) {
		int ord = leftPosition.ord;
		this.game = game;
		this.length = game.randomGen.nextInt(3);
		this.leftPosition = new Case(leftPosition.absc, ord);
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
		 for(int i = 0; i < this.length; ++i) {
			 this.game.getGraphic().add(new Element(this.leftPosition.absc + i,
					 this.leftPosition.ord - this.game.movement_up_down, this.leftToRight ? this.colorLtR : this.colorRtL));
		 }
	}

	public boolean dansLesFrontieres() {
		return this.leftPosition.absc + this.length > 0 || this.leftPosition.absc < this.game.width;
	}

	public boolean isSafe (Case c){

	 		if (c.absc == leftPosition.absc && c.absc < leftPosition.absc + this.length ){
	 			return false;
			}else{
	 			return true;
			}
		}

}

