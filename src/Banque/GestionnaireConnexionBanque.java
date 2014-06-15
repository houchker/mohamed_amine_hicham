package Banque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import model.BanqueO;
import Succursale.Succursale;
import Util.Cts;


public class GestionnaireConnexionBanque implements Runnable {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String login = "zero";
	private Thread t3, t4;
	
	
	public GestionnaireConnexionBanque(Socket s){
		
		socket = s;
		//login = log;
	}
	public void run() {
		
		try {
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());
		String commandLine;
		Succursale s = null;
		while ((commandLine = in.readLine()) != null){
			String[] succursaleCommandes = commandLine.split("#");
			int commandeType = Integer.valueOf(succursaleCommandes[0]);
			switch (commandeType){
			case Cts.AJOUT_SUCCURSALE :
				s = new Succursale(succursaleCommandes[1], Integer.valueOf(succursaleCommandes[2]), Integer.valueOf(succursaleCommandes[3]));
				int idS = BanqueO.getInstance().AddSuccursale(s);
				s.setIdSucc(idS);
				out.println (Cts.NEWIDSUCC+"#"+idS);
				break;
			default:
				System.out.println("Commande introuvable!");

			}
		}
		
		Thread t3 = new Thread(new ReceptionBanque(in,login , s));
		t3.start();
		Thread t4 = new Thread(new EmissionBanque(out, s));
		t4.start();
		
		} catch (IOException e) {
			System.err.println(login +"s'est déconnecté ");
		}
}
}