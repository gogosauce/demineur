

public class Case {
	private boolean etat; //true decouvert, false couvert
	private int val; // le chiffre contenu dans la case
	
	public Case(){
		etat=false;
		val=0;
	}
	
	public int getVal(){
		return val;
	}
	
	public void setVal(int x){
		val=x;
	}
	
	public boolean getEtat(){
		return etat;
	}
	
	public void setEtat(boolean etat){
		this.etat=etat;
	}
}
