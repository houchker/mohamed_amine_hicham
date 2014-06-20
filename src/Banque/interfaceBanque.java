package Banque;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.SuccursaleBean;


public class interfaceBanque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JList<String> list;
	DefaultListModel<String> model;
	private JLabel TotalLabel;
	private JLabel labelError;
	public interfaceBanque() {

		initUI();
	}

	private void initUI() {
		
		model = new DefaultListModel<String>();
	    JScrollPane pane = new JScrollPane();
	    
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setToolTipText("A Panel container");
		panel.setLayout(null);
		list = new JList<String>(model);
		list.setBounds(0, 30, 574, 258);
		panel.add(list);
		
		JLabel lblListeDesSuccursales = new JLabel("Liste des succursales connect\u00E9es : ");
		lblListeDesSuccursales.setBounds(0, 0, 342, 19);
		lblListeDesSuccursales.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblListeDesSuccursales);
		
		TotalLabel = new JLabel("Somme totale d\u2019argent :");
		TotalLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		TotalLabel.setBounds(10, 307, 281, 25);
		panel.add(TotalLabel);
		
		labelError = new JLabel("");
		labelError.setForeground(Color.RED);
		labelError.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelError.setBounds(0, 343, 574, 16);
		panel.add(labelError);
		getContentPane().add(pane, BorderLayout.NORTH);
		setTitle("Tooltip");
		setSize(596, 403);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(0, 0);
		setVisible(true);

		
	}
	
	public void updateSuccursalesList(ArrayList<SuccursaleBean> succursales){
		model.clear();
		for(SuccursaleBean s : succursales)
			model.addElement(s.toString());

		updateMontantTotal(succursales);
	}
	
	public void updateMontantTotal(ArrayList<SuccursaleBean> succursales){
		int total = 0;
		for(SuccursaleBean s : succursales)
			total += s.getMontantDepart();
		TotalLabel.setText("Somme totale d\u2019argent : " + total + " $");
	}	
	public void setMontantTotal(int v){
		TotalLabel.setText("Somme totale d\u2019argent : " + v + " $");
	}

	public void showErrorMEssage(String v){
		labelError.setText(v);
	}	
	
}