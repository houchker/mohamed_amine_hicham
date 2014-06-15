package Banque;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Succursale.Succursale;
import model.SuccursaleO;


public class interfaceBanque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JList list;
	DefaultListModel model;
	private JLabel TotalLabel;
	public interfaceBanque() {

		initUI();
	}

	private void initUI() {
		
		model = new DefaultListModel();
	    JScrollPane pane = new JScrollPane();
	    
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setToolTipText("A Panel container");
		panel.setLayout(null);
		list = new JList(model);
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
		getContentPane().add(pane, BorderLayout.NORTH);
		setTitle("Tooltip");
		setSize(596, 600);
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
		TotalLabel.setText("Somme totale d\u2019argent : " + v + " $");
	}
	
	
}