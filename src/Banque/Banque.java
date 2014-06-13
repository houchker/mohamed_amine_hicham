package Banque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import model.MSuccursale;
import Util.Cts;



public class Banque implements Runnable {

	private ArrayList<MSuccursale> succursales;
	private int montantTotal = 0;
	private BufferedReader in;
	private PrintWriter out;
	static ServerSocket serverSocket = null;
	
	public Banque(){
		succursales = new ArrayList<MSuccursale>();

	}

	public void AjouterSuccursale(MSuccursale s){
		succursales.add(s);
	}
	
	public ArrayList<MSuccursale> getSuccursales(){
		
		return succursales;
		
	}

	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(Cts.BANQUE_PORT);
			while (true){
				Socket clientSocket = serverSocket.accept(); 
				printAllSucc();
				in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream())); 
				out = new PrintWriter(clientSocket.getOutputStream(), true); 
				String commandLine;
				while ((commandLine = in.readLine()) != null){
					String[] succursaleCommandes = commandLine.split("#");
					int commandeType = Integer.valueOf(succursaleCommandes[0]);
					System.out.println(commandeType+"--succursaleCommandes[0]");
					switch (commandeType){
					case Cts.AJOUT_SUCCURSALE :
						succursales.add(new MSuccursale(Integer.valueOf(succursaleCommandes[1]), Integer.valueOf(succursaleCommandes[2])));
						break;
					default:
						System.out.println("Commande introuvable!");
					
					}
				}
	        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private void printAllSucc() {
		for(MSuccursale s : succursales)
			System.out.println("succursales : "+s.toString());

		
	}

	
}
