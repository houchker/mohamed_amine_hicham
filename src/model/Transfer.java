package model;


public class Transfer {


	public Transfer(String from, String to, String montant) {
		this.from = Integer.valueOf(from);
		this.to = Integer.valueOf(to);
		this.montant = Integer.valueOf(montant);
	}
	public Transfer(int from, int to, int montant) {
		this.from = from;
		this.to = to;
		this.montant = montant;
	}
	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	private int montant;
	private int from;
	private int to;

	public String toString() {
		return "Transfer : " + from + " To " + to + " (" + montant + ")";
	}

}
