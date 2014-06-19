package BanqueConnexionSuccursale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import model.BanqueO;
import model.SuccursaleBean;
import Banque.interfaceBanque;
import Succursale.Succursale;
import Util.Cts;


public class GestionnaireConnexionBanque {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String login = "zero";
	private Thread t3, t4;
	private interfaceBanque interfaceBanque;	
	private SuccursaleBean succursale = null;
	private ConnexionEcouteur connexionEcouteur;
	

	public GestionnaireConnexionBanque(Socket s, interfaceBanque interfaceBanque, ConnexionEcouteur connexionEcouteur){
		
		this.interfaceBanque =  interfaceBanque;
		this.socket = s;
		this.connexionEcouteur = connexionEcouteur;
		try {
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());

		Thread t3 = new Thread(new ReceptionBanque(out , in,interfaceBanque , this ));
		t3.start();
		Thread t4 = new Thread(new EmissionBanque(out, in, interfaceBanque, this));
		t4.start();
		
		} catch (IOException e) {
			System.err.println(login +"s'est déconnecté ");
		}
		
	}
	
	public void SendMessage(String message){
		out.println(message);  
		out.flush();
	}

	public void setSuccursale(SuccursaleBean s) {
		succursale = s;
	}
	public ConnexionEcouteur getConnexionEcouteur() {
		return connexionEcouteur;
	}

	public SuccursaleBean getSuccursale() {
		return succursale;
	}
	
}