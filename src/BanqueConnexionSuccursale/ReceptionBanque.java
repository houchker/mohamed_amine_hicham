package BanqueConnexionSuccursale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import model.BanqueO;
import model.SuccursaleBean;
import Banque.interfaceBanque;
import Succursale.Succursale;
import Util.Cts;


public class ReceptionBanque implements Runnable {

	private BufferedReader in;
	private String message = null, login = null;
	private interfaceBanque interfaceBanque;
	private Object succursale;
	private PrintWriter out;
	
	public ReceptionBanque(PrintWriter out, BufferedReader in, interfaceBanque interfaceBanque){
		this.out = out;
		this.interfaceBanque = interfaceBanque;
		this.in = in;
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
					s.setIdSucc(BanqueO.getInstance(interfaceBanque).getCounter());
					BanqueO.getInstance(interfaceBanque).AddSuccursale(s);
					System.out.println("ID succu new " + s.toString());
					out.println (Cts.NEWIDSUCC+"#"+s.getIdSucc());
					out.flush();
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