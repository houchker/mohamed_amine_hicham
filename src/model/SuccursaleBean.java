package model;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import Succursale.interfaceSuccursale;

public class SuccursaleBean {

	private int idSucc;
	private int port;
	private String ip;
	private int montantDepart;
	private int montant;
	private BufferedReader in;
	private PrintWriter out;
	private Socket echoSocket;
	private interfaceSuccursale interfaceSuccursale;
	
	public int getMontantDepart() {
		return montantDepart;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getSolde() {
		return montant;
	}

	public void setSolde(int montantDepart) {
		this.montant = montantDepart;
	}

	public SuccursaleBean(String ip, int portEcoute, int montantDepart) {
		this.ip = ip;
		this.port = portEcoute;
		this.montantDepart = montantDepart;
		this.montant = montantDepart;
	}

	public SuccursaleBean(int id, String ip, int portEcoute, int montantDepart) {
		this.ip = ip;
		this.idSucc = id;
		this.port = portEcoute;
		this.montantDepart = montantDepart;
		this.montant = montantDepart;
	}

	public int getIdSucc() {
		return idSucc;
	}

	public void setIdSucc(int idSucc) {
		this.idSucc = idSucc;
	}

	public int getPortEcoute() {
		return port;
	}

	public void setPortEcoute(int portEcoute) {
		this.port = portEcoute;
	}

	public String toString() {
		return "ID Succ : " + getIdSucc() + "| Port:" + getPortEcoute() + "| Montant Ini:" + getMontantDepart() + "| Solde:"+getSolde();
	}
	public String toString2() {
		return "ID Succ:" + getIdSucc() + "|Port:" + getPortEcoute();
	}
	
	public interfaceSuccursale getInterfaceSuccursale() {
		return interfaceSuccursale;
	}

	public void addSolde(int montant2) {
		montant+=montant2;
	}

}
