package Banque;

import java.io.IOException;
import java.net.ServerSocket;

import BanqueConnexionSuccursale.Accepter_connexion;
import Succursale.interfaceSuccursaleCreator;
import Util.Cts;

public class BanqueMain {

	public static void main(String[] args) throws InterruptedException {
		interfaceBanque interfaceBanque =  new interfaceBanque();
		ServerSocket socket;
		try {
		socket = new ServerSocket(Cts.BANQUE_PORT);
		Thread t = new Thread(new Accepter_connexion(socket , interfaceBanque));
		t.start();
		System.out.println("Le serveur de la banque est pret pour accepter les connexions !");
		new interfaceSuccursaleCreator(interfaceBanque);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
