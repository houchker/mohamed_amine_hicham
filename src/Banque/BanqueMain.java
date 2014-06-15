package Banque;

import java.io.IOException;
import java.net.ServerSocket;

import Util.Cts;

public class BanqueMain {

	public static void main(String[] args) throws InterruptedException {
		ServerSocket socket;
		try {
		socket = new ServerSocket(Cts.BANQUE_PORT);
		Thread t = new Thread(new Accepter_connexion(socket));
		t.start();
		System.out.println("Le serveur de la banque est pret pour accepter les connexions !");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
