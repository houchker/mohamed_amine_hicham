package BanqueConnexionSuccursale;

import java.io.*;
import java.net.*;

import Banque.interfaceBanque;


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
			new GestionnaireConnexionBanque(socket,interfaceBanque);
			}
		} catch (IOException e) {
			
			System.err.println("Erreur serveur");
		}
		
	}
}