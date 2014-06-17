package Succursale;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
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
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;


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
	private SuccursaleBean succursaleBean;
	private JTextField textField;
	private ActionListener controller;
	private JTextField textField_1;
	public interfaceSuccursale(SuccursaleBean succursaleBean2, ActionListener  controller) {
		this.succursaleBean = succursaleBean2;
		this.controller = controller;
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
		textFieldIP.setBounds(169, 49, 101, 20);
		panel.add(textFieldIP);
		
		JLabel lblAdresseIp = new JLabel("Adresse IP :");
		lblAdresseIp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresseIp.setBounds(25, 52, 134, 17);
		panel.add(lblAdresseIp);
		
		textFieldPort = new JTextField("" +succursaleBean.getPortEcoute());
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
		
		textFieldSoldeInit = new JTextField("" +succursaleBean.getSolde());
		textFieldSoldeInit.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSoldeInit.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldSoldeInit.setEditable(false);
		textFieldSoldeInit.setColumns(10);
		textFieldSoldeInit.setBounds(169, 112, 65, 20);
		panel.add(textFieldSoldeInit);
		
		JLabel lblSoldeInitial = new JLabel("Solde initial : ");
		lblSoldeInitial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSoldeInitial.setBounds(25, 115, 134, 17);
		panel.add(lblSoldeInitial);
		
		textField = new JTextField("0");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(169, 143, 65, 20);
		panel.add(textField);
		
		JLabel lblSoldeActuel = new JLabel("Solde actuel : ");
		lblSoldeActuel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSoldeActuel.setBounds(25, 146, 134, 17);
		panel.add(lblSoldeActuel);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		list.setBounds(373, 21, 238, 227);
		panel.add(list);
		
		JLabel lblListeDesSuccursales = new JLabel("Liste des succursales li\u00E9es :");
		lblListeDesSuccursales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListeDesSuccursales.setBounds(373, 7, 238, 17);
		panel.add(lblListeDesSuccursales);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(10, 174, 349, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 11, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMontantTransfert = new JLabel("Montant transfert : ");
		lblMontantTransfert.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMontantTransfert.setBounds(10, 13, 112, 17);
		panel_1.add(lblMontantTransfert);
		
		JLabel lblSuccursale = new JLabel("Succursale : ");
		lblSuccursale.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSuccursale.setBounds(10, 41, 112, 17);
		panel_1.add(lblSuccursale);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 39, 86, 20);
		panel_1.add(comboBox);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addActionListener(controller);
		btnEnvoyer.setBounds(251, 11, 89, 47);
		panel_1.add(btnEnvoyer);
		getContentPane().add(pane, BorderLayout.NORTH);
		setTitle("Tooltip");
		setSize(637, 300);
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
	textFieldID.setText(String.valueOf(succursaleBean.getIdSucc()));
	textFieldIP.setText(succursaleBean.getIp());
	textFieldPort.setText(String.valueOf(succursaleBean.getPortEcoute()));
	textFieldSoldeInit.setText(String.valueOf(succursaleBean.getMontantDepart()));
		
	}
}