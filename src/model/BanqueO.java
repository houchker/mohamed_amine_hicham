package model;

import java.util.ArrayList;

import Succursale.Succursale;
import Banque.interfaceBanque;

public class BanqueO {
	private ArrayList<Succursale> succursales;
	private interfaceBanque interfaceBanque;
	private int count = 0;
	private static BanqueO instance;
	public BanqueO(interfaceBanque interfaceBanque){
		this.interfaceBanque = interfaceBanque;
		succursales = new ArrayList<Succursale>();
	}
	public synchronized void AddSuccursale(Succursale s){
		succursales.add(s);
		interfaceBanque.updateSuccursalesList(succursales);
		System.out.println("AddSuccursale" + s.toString());
	}

	public int getCounter(){
		return count ++;
	}
	public synchronized ArrayList<Succursale> getSuccursales(){
		return succursales;
	}
	public static BanqueO getInstance (interfaceBanque interfaceBanque){
		if(instance == null)
			instance = new BanqueO(interfaceBanque);
		return instance;
	}
	
}
