package model;

import java.util.ArrayList;

import Succursale.Succursale;
import Banque.interfaceBanque;

public class BanqueO {
	private ArrayList<SuccursaleBean> succursales;
	private interfaceBanque interfaceBanque;
	private int count = 0;
	private static BanqueO instance;
	public BanqueO(interfaceBanque interfaceBanque){
		this.interfaceBanque = interfaceBanque;
		succursales = new ArrayList<SuccursaleBean>();
	}
	
	public synchronized void AddSuccursale(SuccursaleBean s){
		
		succursales.add(s);
		interfaceBanque.updateSuccursalesList(succursales);
		//System.out.println("AddSuccursale" + s.toString());
	}

	public int getCounter(){
		return count ++;
	}
	public synchronized ArrayList<SuccursaleBean> getSuccursales(){
		
		return succursales;
	}
	public static BanqueO getInstance (interfaceBanque interfaceBanque){
		if(instance == null)
			instance = new BanqueO(interfaceBanque);
		return instance;
	}
	
}
