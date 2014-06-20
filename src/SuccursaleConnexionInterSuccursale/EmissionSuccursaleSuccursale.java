package SuccursaleConnexionInterSuccursale;

import java.io.PrintWriter;
import java.util.Scanner;

import Succursale.Succursale;
import Util.Cts;


public class EmissionSuccursaleSuccursale implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	private Succursale succursale;

	public EmissionSuccursaleSuccursale(PrintWriter out, Succursale succursale2) {
		succursale = succursale2;
		this.out = out;
	}

	public void run() {
		String message = Cts.SUSCRIBE_SUCCURSALE+"#"+succursale.getSuccursaleBean().getIdSucc()
						+"#"+succursale.getSuccursaleBean().getIp()
						+"#"+succursale.getSuccursaleBean().getPortEcoute()
						+"#"+succursale.getSuccursaleBean().getMontantDepart();
		System.out.println(message);
		out.println(message);  
		out.flush();
	}

	public void EnvoyerMessage(String message){
		out.println(message);  
		out.flush();
	}
}