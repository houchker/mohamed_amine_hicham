package Succursale;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import model.SuccursaleBean;
import model.Transfer;
import SuccursaleConnexionBanque.GestionnaireConnexionSuccursaleBanque;
import SuccursaleConnexionInterSuccursale.GestionnaireConnexionInterSuccursale;
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
	private GestionnaireConnexionInterSuccursale gestionnaireConnexionSuccursaleSuccursale;

	public Succursale(SuccursaleBean succursaleBean1) {
		succursaleBean = succursaleBean1;
		interfaceSuccursale = new interfaceSuccursale(succursaleBean, this);
		gestionnaireConnexionSuccursaleBanque = new GestionnaireConnexionSuccursaleBanque(this, Cts.BANQUE_ADRESSE_IP, Cts.BANQUE_PORT);
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
		Transfer t = new Transfer(succursaleBean.getIdSucc()
				, interfaceSuccursale.getIdSuccForTransfer(), 
				interfaceSuccursale.getmontantTransfert());
		setTransfer(t);
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
		//gestionnaireConnexionSuccursaleSuccursale.addSuccursale(s);
		//gestionnaireConnexionSuccursaleSuccursaleList.add(new GestionnaireConnexionSuccursaleSuccursale(this, s)); 		
		refrechInterface();	
	}

	private void refrechInterface() {
		interfaceSuccursale.updateSuccursalesList(succursaleBeanList);
	}

	public SuccursaleBean getConnectedSuccursaleByID(int id){
		for(SuccursaleBean s1 : succursaleBeanList){
			if(id==s1.getIdSucc()){
				return s1;
			}
		}
		return null;
	}

	public void ConnectToInterm(){
		if(gestionnaireConnexionSuccursaleSuccursale==null)
			gestionnaireConnexionSuccursaleSuccursale = new GestionnaireConnexionInterSuccursale(this,Cts.INTERMEDIAIRE_ADRESSE_IP, Cts.INTERMEDIAIRE_PORT);
	}

	public void setTransfer(Transfer t) {

		if(canTransfer(t)){
			String message =Cts.TRANSFER_SUCCURSALE+"#" 
					+ t.getFrom() + "#"
					+ t.getTo() + "#"
					+ t.getMontant();						
			gestionnaireConnexionSuccursaleSuccursale.EnvoyerMessage(message);
			succursaleBean.addSolde(-t.getMontant());
			interfaceSuccursale.refesh();
		}else{
			interfaceSuccursale.showErrorMessage("Vous ne pouvez pas faire un transfert si votre solde est null ou le montant est supperieur a votre solde.");
		}


	} 

	public void setTransferReceived(Transfer t) {
		succursaleBean.addSolde(t.getMontant());
		refrechInterface();
		interfaceSuccursale.addMessage("Transfert recu : de " 
				+ t.getFrom() + " (" + t.getMontant() +")");
	} 

	private boolean canTransfer(Transfer t){
		if(succursaleBean.getSolde()>=t.getMontant() && succursaleBean.getSolde()> 0)
			return true;

		return false;
	}
}