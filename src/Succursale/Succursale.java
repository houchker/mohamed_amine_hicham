package Succursale;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import Util.Cts;


public class Succursale {
	private int idSucc;
	private int portEcoute;

	public Succursale(int idSucc, int portEcoute) {
		this.idSucc = idSucc;
		this.portEcoute = portEcoute;
		System.out.println("Bonjour suc");
		connecter();
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

	private void connecter() {
		Socket echoSocket = null;

		try {
			echoSocket = new Socket( Cts.BANQUE_ADRESSE_IP, Cts.BANQUE_PORT);
			PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),true);
			out.println(Cts.AJOUT_SUCCURSALE+"#"+this.idSucc+"#"+this.portEcoute);   		
			out.close();
			echoSocket.close();
		} catch (UnknownHostException e) {
			System.err.println("Hôte inconnu: " + Cts.BANQUE_ADRESSE_IP);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Ne pas se connecter à la banque: " + Cts.BANQUE_ADRESSE_IP);
			System.exit(1);
		}


	}

}
