package IntermediaireSuccursale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import model.BanqueO;
import model.SuccursaleBean;
import model.Transfer;
import Banque.interfaceBanque;
import Succursale.Succursale;
import Util.Cts;


public class ReceptionIntermediaire implements Runnable {

	private BufferedReader in;
	private String message = null, login = null;
	private interfaceBanque interfaceBanque;
	private Object succursale;
	private PrintWriter out;
	private GestionnaireConnexionintermediaire getGestionnaireConnexion;
	
	public ReceptionIntermediaire(PrintWriter out, BufferedReader in, interfaceBanque interfaceBanque, GestionnaireConnexionintermediaire gestionnaireConnexionBanque){
		this.out = out;
		this.interfaceBanque = interfaceBanque;
		this.in = in;
		this.getGestionnaireConnexion = gestionnaireConnexionBanque;
	}
	
	public void run() {
		
		String commandLine;
		try {
			while ((commandLine = in.readLine()) != null){
				
				String[] commandes = commandLine.split("#");
				int commandeType = Integer.valueOf(commandes[0]);
				
				switch (commandeType){
				case Cts.SUSCRIBE_SUCCURSALE :
					SuccursaleBean s;
					s = new SuccursaleBean(Integer.valueOf(commandes[1]), commandes[2], Integer.valueOf(commandes[3]), Integer.valueOf(commandes[4]));
					System.out.println("Inter:SUSCRIBE_SUCCURSALE:"+ s.toString());
					getGestionnaireConnexion.setSuccursale(s);
					break;
				case Cts.TRANSFER_SUCCURSALE :
					System.out.println("Inter:TRANSFER_SUCCURSALE: From "+
							commandes[1] + " TO " +
							commandes[2] + " Montant " + 
							commandes[3]);
					Transfer t = new Transfer(commandes[1],commandes[2],commandes[3]);
					getGestionnaireConnexion.doTransfer(t);
					out.println();
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