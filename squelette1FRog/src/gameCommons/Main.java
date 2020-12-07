package gameCommons;
import gameCommons.GameInf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import environment.Car;
import environment.Environment;
import environment.EnvInf;
import frog.Frog;
import frog.FrogInf;
import givenEnvironment.GivenEnvironment;
import graphicalElements.FroggerGraphic;
import graphicalElements.IFroggerGraphics;
import util.Case;

public class Main {

	public static void main(String[] args) {

		//Caract�ristiques du jeu
		int width = 26;
		int height = 20;
		int tempo = 100;
		int minSpeedInTimerLoops = 3;
		double defaultDensity = 0.09;

		//Cr�ation de l'interface graphique
		IFroggerGraphics graphic = new FroggerGraphic(width, height);
		//Cr�ation de la partie
		long startTime = System.currentTimeMillis();
		GameInf game = new GameInf(graphic, width, height, minSpeedInTimerLoops, defaultDensity, startTime);
		//Cr�ation et liason de la grenouille
//		IFrog frog = new Frog(game);
		IFrog frog = new FrogInf(game);
		game.setFrog(frog);
		graphic.setFrog(frog);
		//Cr�ation et liaison de l'environnement
//		IEnvironment env = new Environment(game);
//		game.setEnvironment(env);
//
//		//Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
//		Timer timer = new Timer(tempo, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				game.update();
//				graphic.repaint();
//			}
//		});
//		timer.setInitialDelay(0);
//		timer.start();
//	}
	// Création de l'environnement Infini !
		IEnvironment env = new EnvInf(game);
		game.setEnvironment(env);
		//Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
		Timer timer = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				game.update();
				graphic.repaint();
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}

}
