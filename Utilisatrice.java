import java.util.Scanner;

public class Utilisatrice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int value=0;
		// partie permettant de créer la grille ("nouveau jeu")
		
		//on créé la matrice de dimension voulue
		Matrice mat1= new Matrice(4,4,6);
		
		//on demande les premieres coordonnées
		Scanner sc = new Scanner(System.in);
		System.out.println("saisir les coordonnées x y");
		int xx=sc.nextInt();
		int yy=sc.nextInt();
		
		//on place les mines en conséquence
		mat1.placeMines(xx, yy);
		mat1.incremCadre(); //positionnage des chiffres 
		mat1.afficheMat(); //affichage version développeur
	//	mat1.afficheMatJoueur();  //affichage version joueur 
		mat1.getMat(xx, yy).setEtat(true); // on decouvre la case pour devoiler le chiffre
		if (mat1.getMat(xx, yy).getVal()==0){ // si on trouve un zero 
			mat1.decouvrezero_rec(xx, yy); // on decouvre les cases autour
		}
		mat1.afficheMatJoueur();  //affichage version joueur 
		
		while (value!=9 && mat1.gagner()==false){ //tant que l'on ne tombe pas sur une mine on continue de jouer
			System.out.println("saisir les coordonnées x y");
			int x=sc.nextInt();
			int y=sc.nextInt();
			value=mat1.getMat(x, y).getVal(); // on enregistre la valeur de la case ds la variable value
			if (value!=9){ // si pas de bombe
				mat1.getMat(x, y).setEtat(true); // on decouvre la case pour devoiler le chiffre
				if (value==0){ // si on trouve un zero 
					mat1.decouvrezero_rec(x, y); // on decouvre les cases autour
				}
			}else{
				System.out.println("vous avez perdu!");
				mat1.getMat(x, y).setEtat(true);
				
			}
			mat1.afficheMatJoueur(); //affiche la matrice à jour
		}
		if (mat1.gagner()==true){
			System.out.println("vous avez gagné");
		}
		
		
	}


}
