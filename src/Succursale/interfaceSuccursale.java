package Succursale;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.SuccursaleBean;

import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;


public class interfaceSuccursale extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	DefaultListModel   listModel;
	DefaultComboBoxModel<Integer> comboModel ;
	
	private JTextField textFieldID;
	private JTextField textFieldIP;
	private JTextField textFieldPort;
	private JTextField textFieldSoldeInit;
	private SuccursaleBean succursaleBean;
	private JTextField textSolde;
	private ActionListener controller;
	private JTextField textMontantTransfer;
	private JList list;
	private JComboBox succBox;
	private DefaultListModel listModelMessages;
	private JLabel labelErreur;
	public interfaceSuccursale(SuccursaleBean succursaleBean2, ActionListener  controller) {
		this.succursaleBean = succursaleBean2;
		this.controller = controller;
		initUI();
	}

	private void initUI() {
		comboModel = new DefaultComboBoxModel<Integer>();
		listModel = new DefaultListModel ();
		listModelMessages  = new DefaultListModel ();
		//model = new DefaultListModel();

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setToolTipText("A Panel container");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Succursale :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(25, 22, 134, 17);
		panel.add(lblNewLabel);
		
		textFieldID = new JTextField("" +succursaleBean.getIdSucc());
		textFieldID.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldID.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldID.setEditable(false);
		textFieldID.setBounds(169, 19, 46, 20);
		
		textFieldID.setColumns(10);
		panel.add(textFieldID);
		
		textFieldIP = new JTextField("" +succursaleBean.getIp());
		textFieldIP.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldIP.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldIP.setEditable(false);
		textFieldIP.setColumns(10);
		textFieldIP.setBounds(169, 39, 101, 20);
		panel.add(textFieldIP);
		
		JLabel lblAdresseIp = new JLabel("Adresse IP :");
		lblAdresseIp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresseIp.setBounds(25, 42, 134, 17);
		panel.add(lblAdresseIp);
		
		textFieldPort = new JTextField("" +succursaleBean.getPortEcoute());
		textFieldPort.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPort.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldPort.setEditable(false);
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(169, 59, 46, 20);
		panel.add(textFieldPort);
		
		JLabel label_1 = new JLabel("Port d'ecoute :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(25, 62, 134, 17);
		panel.add(label_1);
		
		textFieldSoldeInit = new JTextField("" +succursaleBean.getSolde());
		textFieldSoldeInit.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSoldeInit.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldSoldeInit.setEditable(false);
		textFieldSoldeInit.setColumns(10);
		textFieldSoldeInit.setBounds(169, 79, 65, 20);
		panel.add(textFieldSoldeInit);
		
		JLabel lblSoldeInitial = new JLabel("Solde initial : ");
		lblSoldeInitial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSoldeInitial.setBounds(25, 82, 134, 17);
		panel.add(lblSoldeInitial);
		
		textSolde = new JTextField("0");
		textSolde.setHorizontalAlignment(SwingConstants.CENTER);
		textSolde.setFont(new Font("Tahoma", Font.BOLD, 12));
		textSolde.setEditable(false);
		textSolde.setColumns(10);
		textSolde.setBounds(169, 99, 65, 20);
		panel.add(textSolde);
		
		JLabel lblSoldeActuel = new JLabel("Solde actuel : ");
		lblSoldeActuel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSoldeActuel.setBounds(25, 102, 134, 17);
		panel.add(lblSoldeActuel);
		
		list = new JList(listModel);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		list.setBounds(373, 21, 238, 158);
		panel.add(list);
		
		JLabel lblListeDesSuccursales = new JLabel("Liste des succursales li\u00E9es :");
		lblListeDesSuccursales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListeDesSuccursales.setBounds(373, 7, 238, 17);
		panel.add(lblListeDesSuccursales);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(9, 122, 349, 58);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textMontantTransfer = new JTextField();
		textMontantTransfer.setBounds(132, 11, 86, 20);
		panel_1.add(textMontantTransfer);
		textMontantTransfer.setColumns(10);
		
		JLabel lblMontantTransfert = new JLabel("Montant transfert : ");
		lblMontantTransfert.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMontantTransfert.setBounds(10, 13, 112, 17);
		panel_1.add(lblMontantTransfert);
		
		JLabel lblSuccursale = new JLabel("ID Succursale : ");
		lblSuccursale.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSuccursale.setBounds(10, 34, 112, 17);
		panel_1.add(lblSuccursale);
		
		succBox = new JComboBox(comboModel);
		succBox.setBounds(132, 32, 86, 20);
		System.out.println("");
		panel_1.add(succBox);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addActionListener(controller);
		btnEnvoyer.setBounds(228, 11, 89, 40);
		panel_1.add(btnEnvoyer);
		
		labelErreur = new JLabel("");
		labelErreur.setForeground(Color.RED);
		labelErreur.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelErreur.setBounds(9, 363, 611, 16);
		panel.add(labelErreur);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 198, 601, 164);
		panel.add(scrollPane);
		
		JList list_1 = new JList(listModelMessages);
		scrollPane.setViewportView(list_1);
		list_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JLabel lblHistoriqueDesTransferts = new JLabel("Historique des transferts re\u00E7us :");
		lblHistoriqueDesTransferts.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHistoriqueDesTransferts.setBounds(9, 182, 238, 17);
		panel.add(lblHistoriqueDesTransferts);
		setTitle("Tooltip");
		setSize(637, 418);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public void updateSuccursalesList(ArrayList<SuccursaleBean> succursales){
		refesh();
		System.out.println(succursaleBean.getIdSucc() +  ":succursales" + succursales.size());
		listModel.removeAllElements();
		comboModel.removeAllElements();
		for(SuccursaleBean s : succursales){
			//System.out.println("Compare:Old=" + s.getIdSucc() + "-TO:" + succursaleBean.getIdSucc());
			listModel.addElement(s.toString2());
			comboModel.addElement(s.getIdSucc());
		}
		showErrorMessage("");
	}

	public void refesh() {
	textFieldID.setText(String.valueOf(succursaleBean.getIdSucc()));
	textFieldIP.setText(succursaleBean.getIp());
	textFieldPort.setText(String.valueOf(succursaleBean.getPortEcoute()));
	textFieldSoldeInit.setText(String.valueOf(succursaleBean.getMontantDepart()));
	textSolde.setText(String.valueOf(succursaleBean.getSolde()));
	showErrorMessage("");
	}
	public int getmontantTransfert(){
		return Integer.parseInt(textMontantTransfer.getText());
	}
	public int getIdSuccForTransfer(){
		return Integer.parseInt(succBox.getSelectedItem().toString());
	}

	public void addMessage(String string) {
		listModelMessages.addElement(string);
	}
	public void showErrorMessage(String string) {
		labelErreur.setText(string);
	}

}