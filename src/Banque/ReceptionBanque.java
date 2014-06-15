package Banque;

import java.io.BufferedReader;
import java.io.IOException;

import model.BanqueO;
import model.SuccursaleO;
import Succursale.Succursale;
import Util.Cts;


public class ReceptionBanque implements Runnable {

	private BufferedReader in;
	private String message = null, login = null;
	
	public ReceptionBanque(BufferedReader in, String login, Succursale s){
		
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
				case Cts.AJOUT_SUCCURSALE :
					BanqueO.getInstance().AddSuccursale(new SuccursaleO(succursaleCommandes[1], Integer.valueOf(succursaleCommandes[2]), Integer.valueOf(succursaleCommandes[3])));
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
		
		
		
		while(true){
	        try {
	        	
			message = in.readLine();
			System.out.println(login+" : "+message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}