package SuccursaleConnexionSuccursale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import Succursale.Succursale;
import Util.Cts;


public class GestionnaireConnexionSuccursalesSuccursale implements Runnable {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String login = "zero";
	private Thread t3, t4;
	private Succursale succursale;


	public GestionnaireConnexionSuccursalesSuccursale(Succursale succursale2){
		succursale = succursale2;
		run();
	}
	public void run() {

		try {
			socket = new Socket( succursale.getSuccursaleBean().getIp(), succursale.getSuccursaleBean().getPortEcoute());
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
		
		Thread t3 = new Thread(new ReceptionSuccursaleSuccursale(in, succursale));
		t3.start();
		Thread t4 = new Thread(new EmissionSuccursaleSuccursale(out, succursale));
		t4.start();

	}
}