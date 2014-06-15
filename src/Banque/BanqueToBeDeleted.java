package Banque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import model.SuccursaleO;
import Util.Cts;

public class BanqueToBeDeleted {

	private ArrayList<SuccursaleO> succursales;
	private BufferedReader in;
	private PrintWriter out;
	static ServerSocket serverSocket = null;
	private interfaceBanque interfaceBanque;
	public BanqueToBeDeleted(){
		System.out.println("Bonjour");
		interfaceBanque = new interfaceBanque();
		interfaceBanque.setVisible(true);
	}

	public void AjouterSuccursale(SuccursaleO s){
		succursales.add(s);
	}

	public ArrayList<SuccursaleO> getSuccursales(){
		return succursales;
	}

	public void runD() {
		try {
			serverSocket = new ServerSocket(Cts.BANQUE_PORT);
			succursales = new ArrayList<SuccursaleO>();
			while (true){
				System.out.println("j'ecoute");
				Socket clientSocket = serverSocket.accept(); 
				updateSuccursalesList();
				in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream())); 
				out = new PrintWriter(clientSocket.getOutputStream(), true); 
				String commandLine;
				while ((commandLine = in.readLine()) != null){
					String[] succursaleCommandes = commandLine.split("#");
					int commandeType = Integer.valueOf(succursaleCommandes[0]);
					switch (commandeType){
					case Cts.AJOUT_SUCCURSALE :
						succursales.add(new SuccursaleO(succursaleCommandes[1], Integer.valueOf(succursaleCommandes[2]), Integer.valueOf(succursaleCommandes[3])));
						out.println (Cts.NEWIDSUCC+"#"+succursales.size()+1);
						break;
					default:
						System.out.println("Commande introuvable!");

					}
				}
				in.close();
				out.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void updateSuccursalesList() {
		//interfaceBanque.updateSuccursalesList(succursales);

	}


}
