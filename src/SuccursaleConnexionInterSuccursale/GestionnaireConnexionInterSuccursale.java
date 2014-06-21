package SuccursaleConnexionInterSuccursale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import model.Transfer;
import Succursale.Succursale;
import SuccursaleConnexionSuccursale.Timerschedule;
import Util.Cts;


public class GestionnaireConnexionInterSuccursale implements Runnable {

	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private Succursale succursale;
	private int port;
	private String ip;
	private ReceptionSuccursaleSuccursale receptionSuccursaleSuccursale;
	private EmissionSuccursaleSuccursale emissionSuccursaleSuccursale;


	public GestionnaireConnexionInterSuccursale(Succursale succursale2, String AdresseIp, int Port){
		succursale = succursale2;
		this.ip = AdresseIp;
		this.port = Port;
		run();
	}
	public void run() {

		try {
			socket = new Socket( ip,port);
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
		
		Thread t3 = new Thread(receptionSuccursaleSuccursale = new ReceptionSuccursaleSuccursale(in, succursale));
		t3.start();
		Thread t4 = new Thread(emissionSuccursaleSuccursale = new EmissionSuccursaleSuccursale(out, succursale));
		t4.start();
	}
	
	public void EnvoyerMessage(String message){
			emissionSuccursaleSuccursale.EnvoyerMessage(message);
	}

	public void EnvoyerTransfert(Transfer t){
		t.setDelay(Cts.DELAYTRANSFER);
		t.setOuter(out);
		Timerschedule.getInstance().addTransferDo(t);
}
	
}