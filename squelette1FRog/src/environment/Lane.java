package environment;

import java.util.ArrayList;


import util.Case;
import gameCommons.Game;

public class Lane {
	private  Game game;
	private  int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;
	private int timer ;

	// TODO : Constructeur(s)

	public Lane (Game game , int ord ) {
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops)+1;
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = game.defaultDensity;

		for (int i = 1 ; i <  game.width ; i++) {
		this.moveCars();
		this.mayAddCar();
		this.afficheCar();

		}
	}




	public void update() {
		// TODO
			if (this.timer <= this.speed) {
				mayAddCar();
				afficheCar();
				this.timer++;
			}else{
				mayAddCar();
				moveCars();
				afficheCar();
				this.timer=0;
			}
	}

		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e



	// TODO : ajout de methodes
		public void moveCars (){
		for (Car car: cars){
			car.move();
		}
		}

		public void afficheCar(){
		for (Car car : cars){
			car.addToGraphics();
		}
	}

		/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase()
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}




	public boolean isSafe(Case c) {
		for (Car car : cars) {
			if (!car.isSafe(c)) {
				return false;
			}}
		return true;
	}



	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
