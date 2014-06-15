package Banque;

import java.io.PrintWriter;
import java.util.Scanner;

import Succursale.Succursale;


public class EmissionBanque implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	
	public EmissionBanque(PrintWriter out, Succursale s) {
		this.out = out;
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