
public class Matrice {
	// creation de la matrice 
	private Case[][] mat;
	private int nbMines; // nb de mines à placer
	private int longueur;
	private int hauteur;
	
	public Matrice(){
		// par defaut la matrice est de dimension 8x8
		// creation et initialisation des cases
		hauteur=8;
		longueur=8;
		mat=new Case[hauteur][longueur];
		nbMines=10;
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				mat[i][j]=new Case();
			}
		}
	}
	
	//constructeur matrice: choix difficulté
	//1 facile, 2 moyen, 3 difficile
	public Matrice(int k){
		if (k==1){
			hauteur=8;
			longueur=8;
			nbMines=10;
		}else if (k==2){
			hauteur=16;
			longueur=16;
			nbMines=40;
		}else if (k==3){
			hauteur=16;
			longueur=30;
			nbMines=99;
		}
		mat=new Case[hauteur][longueur];
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				mat[i][j]=new Case();
			}
		}
	}
	
	public Matrice (int longueur, int hauteur, int mines){
		this.longueur=longueur;
		this.hauteur=hauteur;
		nbMines=mines;
		mat=new Case[hauteur][longueur];
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				mat[i][j]=new Case();
			}
		}
	}
	// a et b correspondent aux coord de la case sur laquelle on a cliqué pour commencer le jeu
	public void placeMines(int a, int b){
		int x, y; //position de la mine
		int i=0; //compteur du nb de mines
		while (i<nbMines){
			x=(int)Math.round(Math.random()*(hauteur-1));
			y=(int)Math.round(Math.random()*(longueur-1));
			// x et y ne doivent pas etre sur a et b ni les cases directement environnantes
			if (mat[x][y].getVal()==0 && (x>(a+1) || x<(a-1)) && (y>(b+1) || y<(b-1))){ 
				mat[x][y].setVal(9); //9 identifiant de la mine 
				i++;
			}
		}
		
	}
	// fonction qui incrémente les valeurs autour d'une case [x][y] 
	public void incremtation (int m, int n, int x, int y){ // m et n sont les limites de la matrice et x, y coord de la case au centre
		for (int i=x-1; i<=x+1; i++){
			for (int j=y-1; j<=y+1; j++){
				if (i!=x || j!=y){
					if (i!=-1 && j!=-1 && i!=n+1 && j!=m+1){
						if (mat[i][j].getVal()!=9){
							mat[i][j].setVal(mat[i][j].getVal()+1);
						}
					}
				}
			}
		}
	}
	
	//faire une fonction qui parcourt la matrice pour trouver les 9 et utiliser incremtation
	public void incremCadre (){
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				if (mat[i][j].getVal()==9){
					incremtation(longueur-1, hauteur-1, i, j);
				}
			}
		}	
	}
	
	
	//permet d'afficher la matrice
	public void afficheMat(){
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				System.out.print(mat[i][j].getVal()+" ");
			}
			System.out.println();
		}
	}
	// affichage de la matrice Joueur selon les cases decouvertes
	public void afficheMatJoueur(){
		for (int i=0; i<hauteur; i++){
			for (int j=0; j<longueur; j++){
				if (mat[i][j].getEtat()==false){
					System.out.print("- ");
				}else{				
					System.out.print(mat[i][j].getVal()+" ");
				}
			}
			System.out.println();
		}
	}
	//getteur pour la matrice
	public Case getMat(int x, int y){
		return mat[x][y];
	}
	
	// fonction recursive pour montrer les cases alentour d'un 0
	public void decouvrezero_rec(int x,int y){
		for (int i=x-1; i<=x+1; i++){ // parcours des cases alentour
			for (int j=y-1; j<=y+1; j++){ //idem
				if (i!=x || j!=y){ // on exclue le centre
					if (i!=-1 && j!=-1 && i!=hauteur && j!=longueur){ // on evite les parties hors matrice
						if(mat[i][j].getEtat()==false){ //on etudie suelement les cases non decouvertes
							mat[i][j].setEtat(true); // on decouvre la case
							if(mat[i][j].getVal()==0){ // si la valeur est à zero
								decouvrezero_rec(i,j); // on appelle la fonction de nouveau
							}
						}
					}
				}
			}	
		}
	}
	
	//fonction verifiant si on a gagné
	public boolean gagner(){
		boolean retour=true;
		for (int i=0; i<hauteur;i++){
			for (int j=0; j<longueur;j++){
				if (mat[i][j].getEtat()!=true && mat[i][j].getVal()!=9){
					retour=false;
				}
			}
		}
		return retour;
	}
}



