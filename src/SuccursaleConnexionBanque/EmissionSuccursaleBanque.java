package SuccursaleConnexionBanque;

import java.io.PrintWriter;
import java.util.Scanner;

import Succursale.Succursale;
import Util.Cts;


public class EmissionSuccursaleBanque implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	private Succursale succursale;

	public EmissionSuccursaleBanque(PrintWriter out, Succursale succursale2) {
		succursale = succursale2;
		this.out = out;
	}

	public void run() {
		out.println(Cts.AJOUT_SUCCURSALE+"#"+succursale.getSuccursaleBean().getIp()+"#"+succursale.getSuccursaleBean().getPortEcoute()+"#"+succursale.getSuccursaleBean().getMontantDepart());  
		out.flush();
	}

	public void EnvoyerMessage(String message){
		out.println(message);  
		out.flush();
	}
}