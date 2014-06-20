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
import IntermediaireSuccursale.InterConnexionEcouteur;

public class BanqueO {
	private ArrayList<SuccursaleBean> succursales;
	private interfaceBanque interfaceBanque;
	private int count = 0;
	private ConnexionEcouteur ConnexionEcouteur;
	private static BanqueO instance;
	
	public BanqueO(){
		succursales = new ArrayList<SuccursaleBean>();
		ServerSocket socket;
		new interfaceSuccursaleCreator();

		//ConnexionEcouteur = new ConnexionEcouteur();
		Thread t = new Thread( new ConnexionEcouteur());
		t.start();
		
		Thread t1 = new Thread( new InterConnexionEcouteur());
		t1.start();
	

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