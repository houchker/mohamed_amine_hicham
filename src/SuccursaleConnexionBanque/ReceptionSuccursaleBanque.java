package SuccursaleConnexionBanque;

import java.io.BufferedReader;
import java.io.IOException;

import model.SuccursaleBean;
import Succursale.Succursale;
import Util.Cts;


public class ReceptionSuccursaleBanque implements Runnable {

	private BufferedReader in;
	private String message = null, login = null;
	private Succursale succursale;

	public ReceptionSuccursaleBanque(BufferedReader in,Succursale succursale2){
		this.succursale = succursale2;
		this.in = in;
	}

	public void run() {
		String commandLine;
		try {
			while ((commandLine = in.readLine()) != null){
				String[] commandes = commandLine.split("#");
				int commandeType = Integer.valueOf(commandes[0]);
				switch (commandeType){
				case Cts.NEWIDSUCC :
					//System.out.println("NEWIDSUCC!");
					succursale.getSuccursaleBean().setIdSucc(Integer.valueOf(commandes[1]));
					succursale.getInterfaceSuccursale().refesh();
					break;
				case Cts.SUSCRIBE_SUCCURSALE :
					SuccursaleBean s = new SuccursaleBean(Integer.valueOf(commandes[1])
							,(commandes[2])
							,Integer.valueOf(commandes[3])
							,Integer.valueOf(commandes[4]));
					//System.out.println(s.getIdSucc() + "|" + succursale.getSuccursaleBean().getIdSucc());
					succursale.addSuccusale(s);
					//System.out.println("Commande addSuccusale!");
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