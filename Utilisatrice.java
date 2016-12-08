# demineur

public class Utilisatrice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrice mat1= new Matrice();
		mat1.placeMines();
		mat1.afficheMat();
		mat1.incremCadre(7, 7, 1, 1);
		System.out.println();
		mat1.afficheMat();
	
	}
}
