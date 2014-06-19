package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import Succursale.Succursale;
import Succursale.interfaceSuccursaleCreator;
import Util.Cts;
import Banque.interfaceBanque;
import BanqueConnexionSuccursale.ConnexionEcouteur;
import BanqueConnexionSuccursale.GestionnaireConnexionBanque;

public class BanqueO {
	private ArrayList<SuccursaleBean> succursales;
	private interfaceBanque interfaceBanque;
	private int count = 0;
	private ConnexionEcouteur ConnexionEcouteur;
	private static BanqueO instance;
	
	public BanqueO(){
		succursales = new ArrayList<SuccursaleBean>();
		ServerSocket socket;
		try {
			//System.out.println("Ecoute");
		socket = new ServerSocket(Cts.BANQUE_PORT);
		new interfaceSuccursaleCreator();
		ConnexionEcouteur = new ConnexionEcouteur(socket);
		Thread t = new Thread(ConnexionEcouteur);
		t.start();
		System.out.println("Le serveur de la banque est pret pour accepter les connexions !");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	public synchronized void AddSuccursale(SuccursaleBean s){
//		succursales.add(s);
//		ConnexionEcouteur.getInterfaceBanque().updateSuccursalesList(succursales);
//		// Envoyer message a l'ensemble des succursales connectées.
//		String message = Cts.SUSCRIBE_SUCCURSALE + "#" + s.getIdSucc()+"#"+s.getIp()+"#"+s.getPortEcoute()+"#"+s.getMontantDepart();
//		for (GestionnaireConnexionBanque g : ConnexionEcouteur.getGestionnaireConnexionBanqueList()){
//			g.SendMessage(message);
//		}
//		
//	}

	public int getCounter(){
		return count ++;
	}
	public synchronized ArrayList<SuccursaleBean> getSuccursales(){
		return succursales;
	}
	public static BanqueO getInstance (){
		if(instance == null)
			instance = new BanqueO();
		return instance;
	}
	
}