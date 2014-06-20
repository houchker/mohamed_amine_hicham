package BanqueConnexionSuccursale;

import java.io.BufferedReader;
import java.io.PrintWriter;

import Banque.interfaceBanque;


public class EmissionBanque implements Runnable {

	private PrintWriter out;
	public EmissionBanque(PrintWriter out, BufferedReader in, interfaceBanque interfaceBanque, GestionnaireConnexionBanque gestionnaireConnexionBanque) {
		this.out = out;
	}

	public void run() {
		
	}
	

	public void EnvoyerMessage(String message){
		out.println(message);  
		out.flush();
	}
}