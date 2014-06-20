package BanqueConnexionSuccursale;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import Util.Cts;
import model.SuccursaleBean;
import Banque.interfaceBanque;


public class ConnexionEcouteur implements Runnable{

	private ServerSocket socketserver = null;
	private Socket socket = null;
	private ArrayList<GestionnaireConnexionBanque> gestionnaireConnexionBanqueList;
	public Thread t1;
	private interfaceBanque interfaceBanque;

	public ConnexionEcouteur(){
		try {
			socketserver = new ServerSocket(Cts.BANQUE_PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Le serveur de la banque est pret pour accepter les connexions !");
		interfaceBanque = new interfaceBanque();
		gestionnaireConnexionBanqueList = new ArrayList<GestionnaireConnexionBanque>();
	}

	
	public interfaceBanque getInterfaceBanque() {
		return interfaceBanque;
	}

	public ArrayList<GestionnaireConnexionBanque> getGestionnaireConnexionBanqueList() {
		return gestionnaireConnexionBanqueList;
	}
	
	public void run() {

		try {
			while(true){
				socket = socketserver.accept();
				System.out.println("Banque: Une succursale s'est connectée");
				gestionnaireConnexionBanqueList.add(new GestionnaireConnexionBanque(socket,interfaceBanque, this));
			}
		} catch (IOException e) {

			System.err.println("Erreur serveur");
		}

	}

	public void informerLesSuccursales(SuccursaleBean s) {
		for (GestionnaireConnexionBanque g : getGestionnaireConnexionBanqueList()){
			String message = Cts.SUSCRIBE_SUCCURSALE + "#" +g.getSuccursale().getIdSucc()+"#"+g.getSuccursale().getIp()+"#"+g.getSuccursale().getPortEcoute()+"#"+g.getSuccursale().getMontantDepart();	
			for (GestionnaireConnexionBanque g1 : getGestionnaireConnexionBanqueList()){
				if(g.getSuccursale().getIdSucc()!=g1.getSuccursale().getIdSucc()){
					//System.out.println("Envoyer message a " + g.getSuccursale().getIdSucc() + " pout ajouter :" + s.getIdSucc());
					g1.SendMessage(message);
				}
			}	
		}		
	}
	
}