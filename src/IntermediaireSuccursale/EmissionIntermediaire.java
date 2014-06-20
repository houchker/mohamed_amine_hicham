package IntermediaireSuccursale;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

import model.SuccursaleBean;
import Banque.interfaceBanque;
import Succursale.Succursale;


public class EmissionIntermediaire implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	private interfaceBanque interfaceBanque;
	private SuccursaleBean succursale;
	private BufferedReader in;
	
	public EmissionIntermediaire(PrintWriter out, BufferedReader in, interfaceBanque interfaceBanque, GestionnaireConnexionintermediaire gestionnaireConnexionBanque) {
		this.interfaceBanque = interfaceBanque;
		this.in = in;
		this.out = out;
	}

	public void run() {
		
	}
	

	public void EnvoyerMessage(String message){
		out.println(message);  
		out.flush();
	}
}