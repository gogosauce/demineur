# demineur
public class Grille {
	// creation de la matrice 
	private int[][] grille=new int[8][8];
	private int nbMines=10; // nb de mines à placer: par defaut 10
	
	public Grille(){
		// par defaut la matrice est de dimension 8x8
		// initialisation de la matrice à zero
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				grille[i][j]=0;
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
			if (grille[x][y]==0){
				grille[x][y]=9; //9 identifiant de la mine 
				i++;
			}
		}
	}
	// fonction qui incrémente les valeurs autour d'une case [x][y] 
	public void incremCadre ( int m, int n, int x, int y){
		for (int i=x-1; i<=x+1; i++){
			for (int j=y-1; j<=y+1; j++){
				if (i!=x || j!=y){
					if (i!=-1 && j!=-1 && i!=n+1 && j!=m+1){
						if (grille[i][j]!=9){
							grille[i][j]+=1;
						}
					}
				}
			}
		}
	}
	
	//faire une fonction qui parcourt la matrice pour trouver les 9 (les mines) et utiliser incremCadre

	public void afficheGrille(){
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				System.out.print(grille[i][j]+" ");
			}
			System.out.println();
		}
	}
}


