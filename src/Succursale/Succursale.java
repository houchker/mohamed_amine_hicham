package Succursale;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import model.SuccursaleBean;
import Banque.interfaceBanque;
import SuccursaleConnexionBanque.GestionnaireConnexionSuccursaleBanque;
import Util.Cts;


public class Succursale implements ActionListener  {

	private int idSucc;
	private int port;
	private String ip;
	private int montantDepart;
	private int montant;
	private BufferedReader in;
	private PrintWriter out;
	private Socket echoSocket;

	private interfaceSuccursale interfaceSuccursale;
	private SuccursaleBean succursaleBean;
	private ArrayList<SuccursaleBean> succursaleBeanList;

	private GestionnaireConnexionSuccursaleBanque g;
	private GestionnaireConnexionSuccursaleBanque gestionnaireConnexionSuccursaleBanque;

	public Succursale(SuccursaleBean succursaleBean1) {
		succursaleBean = succursaleBean1;
		interfaceSuccursale = new interfaceSuccursale(succursaleBean, this);
		gestionnaireConnexionSuccursaleBanque = new GestionnaireConnexionSuccursaleBanque(this);
		succursaleBeanList = new ArrayList<SuccursaleBean>();
	}
	public SuccursaleBean getSuccursaleBean() {
		return succursaleBean;
	}

	public String toString() {
		return "ID Succ :" + succursaleBean.getIdSucc() + "|Port:" + succursaleBean.getPortEcoute() + "|Montant Ini:" + succursaleBean.getMontantDepart() + "| Solde:"+succursaleBean.getSolde();
	}
	public String toString2() {
		return "ID Succ:" + succursaleBean.getIdSucc() + "|Port:" + succursaleBean.getPortEcoute();
	}

	public interfaceSuccursale getInterfaceSuccursale() {
		return interfaceSuccursale;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Bonjour");
	}
	public void addSuccusale(SuccursaleBean s) {
		System.out.println("i m " + succursaleBean.getIdSucc() +  " Called to add :" + s.getIdSucc() );
		boolean found = false;
		String suc="";
		//connectToSuccursale();
		for(SuccursaleBean s1 : succursaleBeanList){
			if(s.getIdSucc()==s1.getIdSucc()){
				return;// exit if the succurasale already is on the list.
			}
		}
			succursaleBeanList.add(s);
			refrechInterface();	
		}

	private void refrechInterface() {
		interfaceSuccursale.updateSuccursalesList(succursaleBeanList);
	}


}