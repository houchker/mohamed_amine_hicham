package SuccursaleConnexionInterSuccursale;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Succursale.Succursale;
import Util.Cts;
import model.SuccursaleBean;
import model.Transfer;

public class TransfertAutomatique implements Runnable {

	private static TransfertAutomatique instance;
	private ArrayList<Transfer> transferList;
	private ArrayList<SuccursaleBean> succursaleBeanList;
	private Succursale succursale;

	public TransfertAutomatique(Succursale succursale1, ArrayList<SuccursaleBean> succursaleBeanList2){
		this.succursaleBeanList = succursaleBeanList2;
		this.succursale = succursale1;
		int montant = 100;
		long temps = 1000;                    
		long startTime = 0;                 
		Timer timer = new Timer();            
		TimerTask tache = new TimerTask() {    
			@Override
			public void run() {
				if(succursaleBeanList.size()>0){
					Transfer t = new Transfer(succursale.getSuccursaleBean().getIdSucc() , randSuccursale(), getRandomAmount());
					succursale.sentAutomtiqueTransfer(t);
				}
			}
		};

		timer.scheduleAtFixedRate(tache,startTime,Cts.AUTOMATIQUE_TRANSFERT_PERIODE);  // ici on lance la mecanique
	}

	public void setSuccursaleList(ArrayList<SuccursaleBean> s){
		succursaleBeanList = s;
	}

	public int randSuccursale() {

		int min1 = 1; 
		int max1 =succursaleBeanList.size() ;
		Random rand = new Random();
		int randomNum = rand.nextInt((max1 - min1) + 1) + min1;
		System.out.println("randomNum-1" + (randomNum-1));
		return succursaleBeanList.get(randomNum-1).getIdSucc() ;

	}

	public int getRandomAmount() {

		int min1 = 1; 
		int max1 = 100 ;
		Random rand = new Random();
		int randomNum = rand.nextInt((max1 - min1) + 1) + min1;
		return randomNum ;

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}



