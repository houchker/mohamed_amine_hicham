package Succursale;

import java.io.BufferedReader;
import java.io.IOException;

import Util.Cts;


public class ReceptionSuccursaleBanque implements Runnable {

	private BufferedReader in;
	private String message = null, login = null;
	private Succursale succursale;
	
	public ReceptionSuccursaleBanque(BufferedReader in, String login, Succursale succursale2){
		this.succursale = succursale2;
		this.in = in;
		this.login = login;
	}
	
	public void run() {
		String commandLine;
		try {
			while ((commandLine = in.readLine()) != null){
				String[] succursaleCommandes = commandLine.split("#");
				int commandeType = Integer.valueOf(succursaleCommandes[0]);
				switch (commandeType){
				case Cts.NEWIDSUCC :
					System.out.println("ID Recu");
					succursale.setIdSucc(Integer.valueOf(succursaleCommandes[1]));
					break;
				default:
					System.out.println("Commande introuvable!");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Erreur NumberFormatException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erreur IOException 2");
			e.printStackTrace();
		}
		
	}

}