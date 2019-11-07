package game;

import java.util.Random;

/**
 * La class Dice est une classe utilitaire qui simule un lanc� de d�
 * @author theoricien
 */

public class Dice {
	/* STATIC METHODS */
	
	/**
	 * la fonction roll() ne prends pas d'argument
	 * @return Elle retourne un int compris entre 1 et 6
	 */
	public static int roll () {
		return new Random().nextInt(6) + 1;
	}
	
	/**
	 * la fonction roll(nbFigurines) prends un argument qui est le nombre de d� qu'on va lancer
	 * @param nbFigurines repr�sente le nombre de figurines pr�sentes dans la zone
	 * @return Elle retourne la somme correspondante a un d� lancer nbFigurines fois.
	 */
	public static int roll (int nbFigurines) {
		if (nbFigurines == 0)
			return 0;
		return Dice.roll() + Dice.roll(nbFigurines - 1);
	}
}
