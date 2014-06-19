package Util;

public class Transfer {

	private int montant;
	private int idSuccursaleSender;
	private int idSuccursaleDestination;
	
	public Transfer(){
		
	}
public Transfer(int montant , int idSuccursaleSender, int idSuccursaleReceiver){
	
		this.montant = montant;
		this.idSuccursaleSender = idSuccursaleSender;
		this.idSuccursaleDestination = idSuccursaleReceiver;
	}
public int getMontant() {
	return montant;
}
public void setMontant(int montant) {
	this.montant = montant;
}

public int getIdSuccursaleSender() {
	return idSuccursaleSender;
}
public void setIdSuccursaleSender(int idSuccursaleSender) {
	this.idSuccursaleSender = idSuccursaleSender;
}
public int getIdSuccursaleDestination() {
	return idSuccursaleDestination;
}
public void setIdSuccursaleDestination(int idSuccursaleDestination) {
	this.idSuccursaleDestination = idSuccursaleDestination;
}


}
