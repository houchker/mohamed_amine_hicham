package model;


public class MSuccursale {
	private int idSucc;
	private int portEcoute;

	public MSuccursale(int idSucc, int portEcoute) {
		this.idSucc = idSucc;
		this.portEcoute = portEcoute;
	}

	public int getIdSucc() {
		return idSucc;
	}

	public void setIdSucc(int idSucc) {
		this.idSucc = idSucc;
	}

	public int getPortEcoute() {
		return portEcoute;
	}

	public void setPortEcoute(int portEcoute) {
		this.portEcoute = portEcoute;
	}

	public String toString() {
		return "Je suis Succ : " + getIdSucc() + " - mon Port est :" + getPortEcoute();
	}

}
