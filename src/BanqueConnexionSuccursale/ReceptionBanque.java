package BanqueConnexionSuccursale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import model.BanqueO;
import model.SuccursaleBean;
import Banque.interfaceBanque;
import Util.Cts;


public class ReceptionBanque implements Runnable {

	private BufferedReader in;
	private interfaceBanque interfaceBanque;
	private PrintWriter out;
	private GestionnaireConnexionBanque getGestionnaireConnexion;
	
	public ReceptionBanque(PrintWriter out, BufferedReader in, interfaceBanque interfaceBanque, GestionnaireConnexionBanque gestionnaireConnexionBanque){
		this.out = out;
		this.interfaceBanque = interfaceBanque;
		this.in = in;
		this.getGestionnaireConnexion = gestionnaireConnexionBanque;
	}
	
	public void run() {
		
		String commandLine;
		try {
			while ((commandLine = in.readLine()) != null){
				
				String[] succursaleCommandes = commandLine.split("#");
				int commandeType = Integer.valueOf(succursaleCommandes[0]);
				
				switch (commandeType){
				case Cts.AJOUT_SUCCURSALE :
					SuccursaleBean s;
					s = new SuccursaleBean(succursaleCommandes[1], Integer.valueOf(succursaleCommandes[2]), Integer.valueOf(succursaleCommandes[3]));
					s.setIdSucc(BanqueO.getInstance().getCounter());
					BanqueO.getInstance().getSuccursales().add(s);
					interfaceBanque.updateSuccursalesList(BanqueO.getInstance().getSuccursales());
					getGestionnaireConnexion.setSuccursale(s);
					out.println (Cts.NEWIDSUCC+"#"+s.getIdSucc());
					out.flush();
					getGestionnaireConnexion.getConnexionEcouteur().informerLesSuccursales(s);
					break;
				default:
					System.out.println("Commande introuvable!");
				}
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}