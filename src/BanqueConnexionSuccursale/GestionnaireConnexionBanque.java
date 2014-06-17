package BanqueConnexionSuccursale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import model.BanqueO;
import model.SuccursaleBean;
import Banque.interfaceBanque;
import Succursale.Succursale;
import Util.Cts;


public class GestionnaireConnexionBanque {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String login = "zero";
	private Thread t3, t4;
	private interfaceBanque interfaceBanque;
	
	
	public GestionnaireConnexionBanque(Socket s, interfaceBanque interfaceBanque){
		this.interfaceBanque =  interfaceBanque;
		this.socket = s;
		try {
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());
		String commandLine;

		Thread t3 = new Thread(new ReceptionBanque(out , in,interfaceBanque ));
		t3.start();
		Thread t4 = new Thread(new EmissionBanque(out, in, interfaceBanque));
		t4.start();
		
		} catch (IOException e) {
			System.err.println(login +"s'est déconnecté ");
		}
	}
	public void run() {
		

}
}