package gameCommons;

import java.awt.Color;
import java.util.Random;

import environment.Car;
import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;
import util.Case;

public class GameInf {

	public final Random randomGen = new Random();

	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;
	public int movement_up_down = 0;
	public final long time_played;
	// Lien aux objets utilis�s
	private IEnvironment environment;
	private IFrog frog;
	private IFroggerGraphics graphic;

	/**
	 *
	 * @param graphic
	 *            l'interface graphique
	 * @param width
	 *            largeur en cases
	 * @param height
	 *            hauteur en cases
	 * @param minSpeedInTimerLoop
	 *            Vitesse minimale, en nombre de tour de timer avant d�placement
	 * @param defaultDensity
	 *            densite de voiture utilisee par defaut pour les routes
	 */
	public GameInf(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity, long time_played) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity;
		this.time_played = time_played;
	}

	/**
	 * Lie l'objet frog � la partie
	 *
	 * @param frog
	 */
	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	/**
	 * Lie l'objet environment a la partie
	 *
	 * @param environment
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 *
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}

	/**
	 * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {
		if (environment.isSafe(frog.getPosition())) {
			return false;
		}else{
			long time_played_in_game = (long) ((System.currentTimeMillis()-this.time_played) /1000.0);

			graphic.endGameScreen("La partie est perdue :'( \n Temps de jeu en sec: " + Long.toString(time_played_in_game));
			return true;
		}
	}

	/**
	 * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si la partie est gagn�e
	 */
	public boolean testWin() {
		if (environment.isWinningPosition(frog.getPosition())) {
			long time_played_in_game = (long) ((System.currentTimeMillis()-this.time_played) /1000.0);

			graphic.endGameScreen("La partie est gagnée :), you have played " + Long.toString(time_played_in_game));
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		graphic.clear();
		environment.update();
		this.graphic.add(new Element(this.frog.getPosition().absc, 1, Color.GREEN));
		testLose();
		testWin();
	}
	public void addLane() {
		this.environment.addLane();
	}
}