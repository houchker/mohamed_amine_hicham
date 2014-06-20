package Succursale;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.SuccursaleBean;

import java.awt.Color;


public class interfaceSuccursaleCreator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultListModel model;
	private JTextField textFieldIP;
	private JTextField textFieldPort;
	private JTextField textFieldSolde;
	private JLabel labelError;
	public interfaceSuccursaleCreator() {
		initUI();
	}

	private void initUI() {


		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setToolTipText("A Panel container");
		panel.setLayout(null);

		JLabel lblListeDesSuccursales = new JLabel("Cr\u00E9ateur succursale :");
		lblListeDesSuccursales.setBounds(10, 11, 174, 19);
		lblListeDesSuccursales.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblListeDesSuccursales);

		textFieldIP = new JTextField();
		textFieldIP.setText("127.0.0.1");
		textFieldIP.setBounds(152, 45, 169, 27);
		panel.add(textFieldIP);
		textFieldIP.setColumns(10);

		textFieldPort = new JTextField();
		textFieldPort.setText("9002");
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(152, 75, 57, 27);
		panel.add(textFieldPort);

		JLabel lblServeurDeLa = new JLabel("Serveur de la banque :");
		lblServeurDeLa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblServeurDeLa.setBounds(10, 44, 142, 27);
		panel.add(lblServeurDeLa);

		JLabel lblPort = new JLabel("Port :");
		lblPort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPort.setBounds(112, 74, 35, 27);
		panel.add(lblPort);

		JButton btnNewButton = new JButton("Cr\u00E9er Succursale");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showError("");
				if((textFieldIP.getText().toString().trim()=="") || 
						(textFieldPort.getText().toString().trim()=="") ||
						(textFieldSolde.getText().toString().trim()=="")){
					showError("Veuillez remplir les trois champs");
					//return;
				}else{
					if(!isInteger(textFieldPort.getText())){
						showError("Port doit etre entier et positif");
						return;
					}
					if(!isInteger(textFieldSolde.getText())){ 
						showError("Montant initial doit etre entier et positif");
						return;
					}
					SuccursaleBean succBean =new SuccursaleBean(textFieldIP.getText(),  Integer.valueOf(textFieldPort.getText()),
							Integer.valueOf(textFieldSolde.getText())); 
					//System.out.println(succBean.getMontantDepart());
					new Succursale(succBean);
					textFieldPort.setText(""+(Integer.valueOf(textFieldPort.getText())+1)) ;

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(152, 147, 134, 35);
		panel.add(btnNewButton);

		textFieldSolde = new JTextField();
		textFieldSolde.setText("200");
		textFieldSolde.setColumns(10);
		textFieldSolde.setBounds(152, 113, 57, 27);
		panel.add(textFieldSolde);

		JLabel lblMontantInitial = new JLabel("Montant initial :");
		lblMontantInitial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMontantInitial.setBounds(48, 112, 99, 27);
		panel.add(lblMontantInitial);

		labelError = new JLabel("");
		labelError.setForeground(Color.RED);
		labelError.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelError.setBounds(10, 193, 365, 16);
		panel.add(labelError);
		setTitle("Créer succursale");
		setSize(401, 247);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}


	public static boolean isInteger(String s) {
		int i=-1;
		try { 
			i = Integer.parseInt(s); 
			if(i<0)
				return false;
		} catch(NumberFormatException e) { 
			return false; 
		}


		return true;
	}

	private void showError(String s){
		labelError.setText(s);
	}

}