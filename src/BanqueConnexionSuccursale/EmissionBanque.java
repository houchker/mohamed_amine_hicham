package BanqueConnexionSuccursale;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

import model.SuccursaleBean;
import Banque.interfaceBanque;


public class EmissionBanque implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	private interfaceBanque interfaceBanque;
	private SuccursaleBean succursale;
	private BufferedReader in;
	
	public EmissionBanque(PrintWriter out, BufferedReader in, interfaceBanque interfaceBanque) {
		this.interfaceBanque = interfaceBanque;
		this.in = in;
		this.out = out;
	}

	public void run() {
		
	}
	

	public void EnvoyerMessage(String message){
		out.println(message);  
		out.flush();
	}
}