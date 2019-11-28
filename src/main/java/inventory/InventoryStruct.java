package inventory;

import java.util.ArrayList;

import game.CarteCivilisation;
import game.Ressource;
import game.Settings;

/**
 * La classe asbtract Inventory represente l'inventaire du joueur. 
 */

public abstract class InventoryStruct {


	/* FIELDS */
	// Les ressources que peut avoir le joueur. 
	private int[] ressources;
	private int buildings;
	private ArrayList<CarteCivilisation> carteCivilisation;

	/* CONSTRUCTOR */
	protected InventoryStruct () {
		ressources = new int[Settings.NB_RESSOURCES];
		ressources[Ressource.FOOD.getIndex()]=15;
		buildings = 0;
		carteCivilisation = new ArrayList<CarteCivilisation>();
	}

	//GETTERS
	public int getRessource(Ressource ressource){ return ressources[ressource.getIndex()] ;}
	public int[] getCopyRessources() {return ressources.clone();}
	public CarteCivilisation[] getCardCivilisation() {
		CarteCivilisation[] cardCivi = new CarteCivilisation[carteCivilisation.size()];
		for(int i=0; i<cardCivi.length; i++) { cardCivi[i]=carteCivilisation.get(i); }
		return cardCivi;
	}
	public int getBuildings() { return buildings; }


	//ADDERS
	protected void addCardCivilisation(CarteCivilisation card){
		carteCivilisation.add(card);
	}
	/**
	 * La fonction addRessource ajoute number ressource a l'inventaire du joueur. 
	 * @param ressource la ressource 
	 * @param number le nombre de ressources gagnee. 
	 */
	protected void addRessource(Ressource ressource,int number){
		ressources[ressource.getIndex()]+=number;
	}

	protected void incrementBuilding() {this.buildings += 1;}


	//SUBSTRACTORS
	/**
	 * La fonction addRessource soustrait number ressource a l'inventaire du joueur. 
	 * @param ressource la ressource
	 * @param number le nombre de ressources retiree. 
	 */
	protected void subRessource(Ressource ressource,int number) {
		ressources[ressource.getIndex()]-=number;
	}

	/**
	 * Verification si la ressource reste en nombre possitif
	 * @param ressource Ressource que l'on dois soustraire.
	 * @param number Nombre de ressource a soustraire.
	 * @return true : Reste positif. false : deviens negatif.
	 * 
	 */
	public boolean ableToSubRessource(Ressource ressource,int number) {
		if(ressources[ressource.getIndex()] < number) return false;
		return true;
	}

	/**
	 * Ressource utilisable total 
	 * (utiliser pour voir si le joueur peut nourire toutes les figurine quand il a plus de nouriture)
	 * @return somme des ressource usable pour remplacer la nouriture
	 */
	public int availableResourceToFeed() {
		int sum=0;
		for(int i=0; i<=3;i++) {
			sum+=ressources[i];
		}
		return sum;
	}
}