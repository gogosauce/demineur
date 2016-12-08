
public class Matrice {
	// creation de la matrice 
	private Case[][] mat=new Case[8][8];
	private int nbMines=10; // nb de mines à placer: par defaut 10
	
	public Matrice(){
		// par defaut la matrice est de dimension 8x8
		// creation et initialisation des cases
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				mat[i][j]=new Case();
			}
		}
	}
	
	public void placeMines(){
		int x, y; //position de la mine
		int i=0; //compteur du nb de mines
		while (i<10){
			//pour les 10 mines
			x=(int)Math.round(Math.random()*7);
			y=(int)Math.round(Math.random()*7);
			if (mat[x][y].getVal()==0){
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
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				if (mat[i][j].getVal()==9){
					incremtation(7, 7, i, j);
				}
			}
		}	
	}
	
	
	//permet d'afficher la matrice
	public void afficheMat(){
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				System.out.print(mat[i][j].getVal()+" ");
			}
			System.out.println();
		}
	}
	// affichage de la matrice Joueur selon les cases decouvertes
	public void afficheMatJoueur(){
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
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
	public void recursive(int x,int y){
		for (int i=x-1; i<=x+1; i++){ // parcours des cases alentour
			for (int j=y-1; j<=y+1; j++){ //idem
				if (i!=x || j!=y){ // on exclue le centre
					if (i!=-1 && j!=-1 && i!=8 && j!=8){ // on evite les parties hors matrice
						if(mat[i][j].getEtat()==false){ //on etudie suelement les cases non decouvertes
							mat[i][j].setEtat(true); // on decouvre la case
							if(mat[i][j].getVal()==0){ // si la valeur est à zero
								recursive(i,j); // on appelle la fonction de nouveau
							}
						}
					}
				}
			}	
		}
	}
}



