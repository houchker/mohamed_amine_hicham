package Banque;

import java.io.*;
import java.net.*;


public class Accepter_connexion implements Runnable{

	private ServerSocket socketserver = null;
	private Socket socket = null;

	public Thread t1;
	private interfaceBanque interfaceBanque;
	public Accepter_connexion(ServerSocket ss){
	 socketserver = ss;
	 interfaceBanque = new interfaceBanque();
	}
	
	public void run() {
		
		try {
			while(true){
			socket = socketserver.accept();
			System.out.println("Une succursale s'est connectée");
			t1 = new Thread(new GestionnaireConnexionBanque(socket,interfaceBanque));
			t1.start();
			}
		} catch (IOException e) {
			
			System.err.println("Erreur serveur");
		}
		
	}
}