package Banque;

import java.io.PrintWriter;
import java.util.Scanner;

import model.SuccursaleBean;
import Succursale.Succursale;


public class EmissionBanque implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	private interfaceBanque interfaceBanque;
	private SuccursaleBean succursale;
	
	public EmissionBanque(PrintWriter out, SuccursaleBean s, interfaceBanque interfaceBanque) {
		this.interfaceBanque = interfaceBanque;
		this.out = out;
		this.succursale = s;
	}

	public void run() {
		
		  sc = new Scanner(System.in);
		  
		  while(true){
			    System.out.println("Votre message :");
				message = sc.nextLine();
				out.println(message);
			    out.flush();
			  }
	}
}