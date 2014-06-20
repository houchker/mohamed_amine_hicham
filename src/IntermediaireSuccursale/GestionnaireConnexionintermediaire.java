package IntermediaireSuccursale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import model.BanqueO;
import model.SuccursaleBean;
import model.Transfer;
import Banque.interfaceBanque;
import Succursale.Succursale;
import Util.Cts;


public class GestionnaireConnexionintermediaire {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String login = "zero";
	private Thread t3, t4;
	private interfaceBanque interfaceBanque;	
	private SuccursaleBean succursale = null;
	private InterConnexionEcouteur connexionEcouteur;
	

	public GestionnaireConnexionintermediaire(Socket s, interfaceBanque interfaceBanque, InterConnexionEcouteur connexionEcouteur){
		
		this.interfaceBanque =  interfaceBanque;
		this.socket = s;
		this.connexionEcouteur = connexionEcouteur;
		
		try {
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());

		Thread t3 = new Thread(new ReceptionIntermediaire(out , in,interfaceBanque , this ));
		t3.start();
		Thread t4 = new Thread(new EmissionIntermediaire(out, in, interfaceBanque, this));
		t4.start();
		
		} catch (IOException e) {
			System.err.println(login +"s'est déconnecté ");
		}
		
	}
	
	public void envoyerMessage(String message){
		out.println(message);  
		out.flush();
	}

	public void doTransfer(Transfer t){
		connexionEcouteur.doTransfer(t);
	}
	
	public void setSuccursale(SuccursaleBean s) {
		succursale = s;
	}
	public InterConnexionEcouteur getConnexionEcouteur() {
		return connexionEcouteur;
	}

	public SuccursaleBean getSuccursale() {
		return succursale;
	}
	
}