package printer;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Singleton qui permet d'afficher ou non les information de jeu
 * @author Yohann
 *
 */
public class Printer {
	private static Printer uniqueInstance = null;
	private boolean write;
	
	private Printer(boolean canWrite) {
		this.write = canWrite;
		try {
			System.setOut(new PrintStream(System.out, true, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * crée l'unique instance printer et definie si il vas avoir un affichage
	 * @param canWrite true: on affiche sur la sorti standard ; ; false: on affiche rien
	 * @return renvoie l'instance du printer.
	 */
	public static Printer Instance(boolean canWrite) {
		if (uniqueInstance == null) {
			uniqueInstance = new Printer(canWrite);
		}
		return uniqueInstance;
	}
	
	/**
	 * fonctionne comme instance mais ne necesite pas de parametre (utiliser pour appeler les print)
	 * @return l'instance du printer
	 */
	public static Printer getPrinter() {
		// si il est pas instancier -> probablement des test on l'instancie a false
		return Instance(false);
	}
	
	/**
	 * Permet de changer l'activation ou non de l'affichage
	 * @param write true : affiche / false : n'affiche pas;
	 */
	public void setPrinterCanWrite(boolean write) {
		this.write = write;
	}
	
	/* PRINTER */
	/**
	 * print une chaine de caractere avec retour a la ligne a la fin.
	 * @param str chaine de caractere a afficher.
	 */
	public void println(String str) {
		if (write) {
			System.out.println(str);
		}
	}
	/**
	 * retour a la ligne
	 */
	public void println() {
		if (write) {
			System.out.println();
		}
	}
	
	/**
	 * print une chaine de caractere
	 * @param str chaine de caractere a afficher.
	 */
	public void print(String str) {
		if (uniqueInstance != null && write) {
			System.out.print(str);
		}
	}
	
}
