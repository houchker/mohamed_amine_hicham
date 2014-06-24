package SuccursaleConnexionInterSuccursale;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import Util.Cts;
import model.Transfer;

public class Timerschedule {

	private static Timerschedule instance;
	private ArrayList<Transfer> transferList;
	public Timerschedule(){
		transferList = new ArrayList<Transfer>();
		long temps = 1000;                    
		long startTime = 0;                 
		Timer timer = new Timer();            
		TimerTask tache = new TimerTask() {    
			@Override
			public void run() {

				for (Iterator<Transfer> it = transferList.iterator(); it.hasNext(); ) {
					Transfer t = it.next();

					if(t.getDelay()<=0){
						String message =Cts.TRANSFER_SUCCURSALE+"#" 
								+ t.getFrom() + "#"
								+ t.getTo() + "#"
								+ t.getMontant();	
						t.getOuter().println(message);  
						t.getOuter().flush();
						it.remove();
					}else{
						t.setDelay(t.getDelay()-1);
					}

				}

			}
		};

		timer.scheduleAtFixedRate(tache,startTime,temps);  // ici on lance la mecanique
	}

	public static Timerschedule getInstance(){
		if(instance==null)
			instance = new Timerschedule();
		return instance;
	}


	public void addTransferDo(Transfer t){
		transferList.add(t);
	}

}



