
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import Util.Cts;



public class Banque implements Runnable {

	private ArrayList<Succursale> succursales;
	private int montantTotal = 0;
	private BufferedReader in;
	private PrintWriter out;
	static ServerSocket serverSocket = null;
	
	public Banque(){
		succursales = new ArrayList<Succursale>();

	}

	public void AjouterSuccursale(Succursale s){
		succursales.add(s);
	}
	
	public ArrayList<Succursale> getSuccursales(){
		
		return succursales;
		
	}

	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(Cts.BANQUE_PORT);
			while (true){
				System.out.println("j'attends");
				Socket clientSocket = serverSocket.accept(); 
				//printAllSucc();
				in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream())); 
				out = new PrintWriter(clientSocket.getOutputStream(), true); 
				String commandLine;
				
				while ((commandLine = in.readLine()) != null){
					
					String[] succursaleCommandes = commandLine.split("#");
					System.out.println(succursaleCommandes[0]+"--succursaleCommandes[0]");
					switch (Integer.valueOf(succursaleCommandes[0])){
					case Cts.AJOUT_SUCCURSALE :
						succursales.add(new Succursale(Integer.valueOf(succursaleCommandes[1]), Integer.valueOf(succursaleCommandes[2])));
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
		System.out.println("succursales.size()"+succursales.size());

		
	}

	
}
