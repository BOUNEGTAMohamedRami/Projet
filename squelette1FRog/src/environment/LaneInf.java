package environment;
import gameCommons.GameInf;
import util.Case;

import java.util.ArrayList;
import java.util.Iterator;

public class LaneInf {
	private  GameInf game;
	public  int ord;
	private int speed;
	private ArrayList<CarInf> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;
	private int timer ;

	// TODO : Constructeur(s)

	public LaneInf(GameInf game , int ord, double density ) {
		this.game = game;
		this.ord = ord;
		this.density = density;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops)+1;
		this.leftToRight = game.randomGen.nextBoolean();

		for (int i = 0 ; i <  game.width ; i++) {
		this.moveCars();
		this.mayAddCar();
		this.afficheCar();

		}

	}

	public LaneInf(GameInf game, int ord) {
		this(game, ord, game.defaultDensity);
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
			Iterator var3 = this.cars.iterator();

			while(var3.hasNext()) {
				CarInf car = (CarInf)var3.next();
				car.move();
			}

			this.removeOldCars();
		}

	private void removeOldCars() {
		ArrayList<CarInf> toBeRemoved = new ArrayList();
		Iterator var3 = this.cars.iterator();

		CarInf c;
		while(var3.hasNext()) {
			c = (CarInf)var3.next();
			if (!c.dansLesFrontieres()) {
				toBeRemoved.add(c);
			}

		}
		var3 = toBeRemoved.iterator();
		while(var3.hasNext()) {
			c = (CarInf)var3.next();
			this.cars.remove(c);
		}

	}

		public void afficheCar(){
		for (CarInf car : cars){
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
			if (game.randomGen.nextDouble() < this.density) {
				cars.add(new CarInf(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}



	public boolean isSafe(Case c) {
		for (CarInf car : cars) {
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
