package SuccursaleConnexionBanque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import Succursale.Succursale;
import Util.Cts;


public class GestionnaireConnexionSuccursaleBanque implements Runnable {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String login = "zero";
	private Thread t3, t4;
	private Succursale succursale;


	public GestionnaireConnexionSuccursaleBanque(Succursale succursale2){
		succursale = succursale2;
		run();
	}
	public void run() {

		try {
			socket = new Socket( Cts.BANQUE_ADRESSE_IP, Cts.BANQUE_PORT);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t3 = new Thread(new ReceptionSuccursaleBanque(in,login , succursale));
		t3.start();
		Thread t4 = new Thread(new EmissionSuccursaleBanque(out, succursale));
		t4.start();

	}
}