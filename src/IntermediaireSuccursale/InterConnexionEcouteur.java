package IntermediaireSuccursale;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import Util.Cts;
import model.SuccursaleBean;
import model.Transfer;
import Banque.interfaceBanque;


public class InterConnexionEcouteur implements Runnable{

	private ServerSocket socketserver = null;
	private Socket socket = null;
	private ArrayList<GestionnaireConnexionintermediaire> gestionnaireConnexionBanqueList;
	public Thread t1;
	private interfaceBanque interfaceBanque;

	public InterConnexionEcouteur(){
		try {
			socketserver = new ServerSocket(Cts.INTERMEDIAIRE_PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Le serveur intermediaire est pret pour accepter les connexions !");
		gestionnaireConnexionBanqueList = new ArrayList<GestionnaireConnexionintermediaire>();
	}

	
	public interfaceBanque getInterfaceBanque() {
		return interfaceBanque;
	}

	public ArrayList<GestionnaireConnexionintermediaire> getGestionnaireConnexionBanqueList() {
		return gestionnaireConnexionBanqueList;
	}
	
	public void run() {

		try {
			while(true){
				socket = socketserver.accept();
				System.out.println("Inter:Une succursale s'est connectée");
				gestionnaireConnexionBanqueList.add(new GestionnaireConnexionintermediaire(socket,interfaceBanque, this));
			}
		} catch (IOException e) {

			System.err.println("Erreur serveur");
		}

	}

	public void informerLesSuccursales(SuccursaleBean s) {
		for (GestionnaireConnexionintermediaire g : getGestionnaireConnexionBanqueList()){
			String message = Cts.SUSCRIBE_SUCCURSALE + "#" +g.getSuccursale().getIdSucc()+"#"+g.getSuccursale().getIp()+"#"+g.getSuccursale().getPortEcoute()+"#"+g.getSuccursale().getMontantDepart();	
			for (GestionnaireConnexionintermediaire g1 : getGestionnaireConnexionBanqueList()){
				if(g.getSuccursale().getIdSucc()!=g1.getSuccursale().getIdSucc()){
					g1.envoyerMessage(message);
				}
			}	
		}		
	}


	public void doTransfer(Transfer t) {
		String message;
		for (GestionnaireConnexionintermediaire g : gestionnaireConnexionBanqueList){
			if(g.getSuccursale().getIdSucc()==t.getTo()){
				message = Cts.TRANSFER_SUCCURSALE + "#"
							+ t.getFrom() + "#"
							+t.getMontant();
				g.envoyerMessage(message);
				break;
			}
		}
	}
	
}