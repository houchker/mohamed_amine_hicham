package model;

import java.util.ArrayList;

import Succursale.Succursale;
import Banque.interfaceBanque;

public class BanqueO {
	private ArrayList<Succursale> succursales;
	private interfaceBanque interfaceBanque;
	private static BanqueO instance;
	public BanqueO(){
		succursales = new ArrayList<Succursale>();
		interfaceBanque = new interfaceBanque();
		interfaceBanque.setVisible(true);
	}
	public synchronized int AddSuccursale(Succursale s){
		succursales.add(s);
		interfaceBanque.updateSuccursalesList(succursales);
		return succursales.size();
	}

	public synchronized ArrayList<Succursale> getSuccursales(){
		return succursales;
	}
	public static BanqueO getInstance (){
		if(instance == null)
			instance = new BanqueO();
		return instance;
	}
	
}
