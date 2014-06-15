package Succursale;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.SuccursaleBean;


public class interfaceSuccursale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultListModel model;
	private JTextField textFieldID;
	private JTextField textFieldIP;
	private JTextField textFieldPort;
	private JTextField textFieldSoldeInit;
	private SuccursaleBean succursale;
	public interfaceSuccursale(SuccursaleBean succursaleBean2) {
		this.succursale = succursaleBean2;
		initUI();
	}

	private void initUI() {

		model = new DefaultListModel();
		JScrollPane pane = new JScrollPane();

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setToolTipText("A Panel container");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Succursale :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(25, 22, 134, 17);
		panel.add(lblNewLabel);
		
		textFieldID = new JTextField();
		textFieldID.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldID.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldID.setEditable(false);
		textFieldID.setBounds(169, 19, 46, 20);
		panel.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldIP = new JTextField();
		textFieldIP.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIP.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldIP.setEditable(false);
		textFieldIP.setColumns(10);
		textFieldIP.setBounds(169, 49, 101, 20);
		panel.add(textFieldIP);
		
		JLabel lblAdresseIp = new JLabel("Adresse IP :");
		lblAdresseIp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresseIp.setBounds(25, 52, 134, 17);
		panel.add(lblAdresseIp);
		
		textFieldPort = new JTextField();
		textFieldPort.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPort.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldPort.setEditable(false);
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(169, 80, 46, 20);
		panel.add(textFieldPort);
		
		JLabel label_1 = new JLabel("Port d'ecoute :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(25, 83, 134, 17);
		panel.add(label_1);
		
		textFieldSoldeInit = new JTextField();
		textFieldSoldeInit.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSoldeInit.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldSoldeInit.setEditable(false);
		textFieldSoldeInit.setColumns(10);
		textFieldSoldeInit.setBounds(169, 115, 65, 20);
		panel.add(textFieldSoldeInit);
		
		JLabel lblSoldeInitial = new JLabel("Solde initial : ");
		lblSoldeInitial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSoldeInitial.setBounds(25, 118, 134, 17);
		panel.add(lblSoldeInitial);
		getContentPane().add(pane, BorderLayout.NORTH);
		setTitle("Tooltip");
		setSize(596, 197);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void updateSuccursalesList(ArrayList<Succursale> succursales){
		model.clear();
		for(Succursale s : succursales)
			model.addElement(s.toString());

	}

	public void setMontantTotal(int v){
		//TotalLabel.setText("Somme totale d\u2019argent : " + v + " $");
	}

	public void refesh() {
	textFieldID.setText(String.valueOf(succursale.getIdSucc()));
	textFieldIP.setText(succursale.getIp());
	textFieldPort.setText(String.valueOf(succursale.getPortEcoute()));
	textFieldSoldeInit.setText(String.valueOf(succursale.getMontantDepart()));
		
	}
}