package Succursale;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import model.SuccursaleBean;
import Banque.interfaceBanque;
import Util.Cts;


public class Succursale implements Runnable {

	private int idSucc;
	private int port;
	private String ip;
	private int montantDepart;
	private int montant;
	private BufferedReader in;
	private PrintWriter out;
	private Socket echoSocket;
	public SuccursaleBean getSuccursaleBean() {
		return succursaleBean;
	}

	public void setSuccursaleBean(SuccursaleBean succursaleBean) {
		this.succursaleBean = succursaleBean;
	}


	private interfaceSuccursale interfaceSuccursale;
	private SuccursaleBean succursaleBean;
	
	public int getMontantDepart() {
		return montantDepart;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getSolde() {
		return montant;
	}

	public void setSolde(int montantDepart) {
		this.montant = montantDepart;
	}

	public Succursale(SuccursaleBean succursaleBean2) {
		this.succursaleBean = succursaleBean2;
		interfaceSuccursale = new interfaceSuccursale(succursaleBean2);
	}

	public int getIdSucc() {
		return idSucc;
	}

	public void setIdSucc(int idSucc) {
		this.idSucc = idSucc;
	}

	public int getPortEcoute() {
		return port;
	}

	public void setPortEcoute(int portEcoute) {
		this.port = portEcoute;
	}

	public String toString() {
		return "ID Succ : " + getIdSucc() + "| Port:" + getPortEcoute() + "| Montant Ini:" + getMontantDepart() + "| Solde:"+getSolde();
	}
	public String toString2() {
		return "ID Succ:" + getIdSucc() + "|Port:" + getPortEcoute();
	}
	
	public interfaceSuccursale getInterfaceSuccursale() {
		return interfaceSuccursale;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket socket;
		try {
		echoSocket = new Socket( Cts.BANQUE_ADRESSE_IP, Cts.BANQUE_PORT);
		Thread t = new Thread(new GestionnaireConnexionSuccursaleBanque(echoSocket, this));
		t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



/*	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			echoSocket = new Socket( Cts.BANQUE_ADRESSE_IP, Cts.BANQUE_PORT);
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			in = new BufferedReader(new InputStreamReader( echoSocket.getInputStream()));
		} catch (IOException e1) {
			System.out.println("Erreur IOException 1");
			e1.printStackTrace();
		} 
		String commandLine;
		try {
			while ((commandLine = in.readLine()) != null){
				String[] succursaleCommandes = commandLine.split("#");
				int commandeType = Integer.valueOf(succursaleCommandes[0]);
				switch (commandeType){
				case Cts.NEWIDSUCC :
					System.out.println("ID Recu");
					idSucc = Integer.valueOf(succursaleCommandes[0]);
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
	}*/

}
