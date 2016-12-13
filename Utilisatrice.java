import java.util.Scanner;

public class Utilisatrice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int value=0;
		// partie permettant de créer la grille ("nouveau jeu")
		Matrice mat1= new Matrice();
		mat1.placeMines();
		mat1.incremCadre();
		mat1.afficheMat(); //affichage version développeur
		mat1.afficheMatJoueur();  //affichage version joueur 
		
		Scanner sc = new Scanner(System.in);
		while (value!=9){ //tant que l'on ne tombe pas sur une mine on continue de jouer
			System.out.println("saisir les coordonnées x y");
			int x=sc.nextInt();
			int y=sc.nextInt();
			value=mat1.getMat(x, y).getVal(); // on enregistre la valeur de la case ds la variable value
			if (value!=9){ // si pas de bombe
				mat1.getMat(x, y).setEtat(true); // on decouvre la case pour devoiler le chiffre
				if (value==0){ // si on trouve un zero 
					mat1.recursive(x, y); // on decouvre les cases autour
				}
			}else{
				System.out.println("vous avez perdu!");
				mat1.getMat(x, y).setEtat(true);
			}
			mat1.afficheMatJoueur(); //affiche la matrice à jour
		}
		
	}


}
