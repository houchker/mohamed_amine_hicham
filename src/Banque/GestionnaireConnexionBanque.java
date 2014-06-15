package Banque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import model.BanqueO;
import model.SuccursaleBean;
import Succursale.Succursale;
import Util.Cts;


public class GestionnaireConnexionBanque implements Runnable {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String login = "zero";
	private Thread t3, t4;
	private interfaceBanque interfaceBanque;
	
	
	public GestionnaireConnexionBanque(Socket s, interfaceBanque interfaceBanque){
		this.interfaceBanque =  interfaceBanque;
		this.socket = s;
		//login = log;
	}
	public void run() {
		
		try {
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());
		String commandLine;
		SuccursaleBean s = null;
		while ((commandLine = in.readLine()) != null){
			String[] succursaleCommandes = commandLine.split("#");
			int commandeType = Integer.valueOf(succursaleCommandes[0]);
			switch (commandeType){
			case Cts.AJOUT_SUCCURSALE :
				s = new SuccursaleBean(succursaleCommandes[1], Integer.valueOf(succursaleCommandes[2]), Integer.valueOf(succursaleCommandes[3]));
				s.setIdSucc(BanqueO.getInstance(interfaceBanque).getCounter());
				BanqueO.getInstance(interfaceBanque).AddSuccursale(s);
				System.out.println("ID succu new " + s.toString());
				out.println (Cts.NEWIDSUCC+"#"+s.getIdSucc());
				
				break;
			default:
				System.out.println("Commande introuvable!");

			}
		}
		
		Thread t3 = new Thread(new ReceptionBanque(in,login , s ,interfaceBanque ));
		t3.start();
		Thread t4 = new Thread(new EmissionBanque(out, s , interfaceBanque));
		t4.start();
		
		} catch (IOException e) {
			System.err.println(login +"s'est déconnecté ");
		}
}
}