package Banque;

import java.io.IOException;
import java.net.ServerSocket;

import model.BanqueO;
import BanqueConnexionSuccursale.ConnexionEcouteur;
import Succursale.interfaceSuccursaleCreator;
import Util.Cts;

public class BanqueMain {

	public static void main(String[] args) throws InterruptedException {
		BanqueO.getInstance();
	}

}